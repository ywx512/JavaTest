package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/**
 * @author ywx
 * @Date 2020年6月14日 下午10:37:10
 * @Description:
 */
public class Demo {
	public static final int BSIZE = 1024;

	public static final String fileName1 = "data.txt";
	public static final String fileName2 = "data2.txt";
	public static final String fileName3 = "data3.txt";

	public static void main(String[] args) throws IOException {
//		baseTest();
//		TransferToDemo();
//		BufferToText();
		UTF8Demo();
	}

	@SuppressWarnings("resource")
	public static void baseTest() throws IOException {
		FileChannel fileChannel = new FileOutputStream(fileName1).getChannel();
		fileChannel.write(ByteBuffer.wrap("test nioFile".getBytes("UTF-8")));
		fileChannel.close();

		fileChannel = new RandomAccessFile(fileName1, "rw").getChannel();
		fileChannel.position(fileChannel.size());
		fileChannel.write(ByteBuffer.wrap("another nioFile".getBytes("UTF-8")));
		fileChannel.close();

		fileChannel = new FileInputStream("data.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		fileChannel.read(buffer);
		buffer.flip();
		while (buffer.hasRemaining()) {
			System.out.print((char) buffer.get());
		}
		System.out.println("");
	}

	@SuppressWarnings("resource")
	public static void ChannelCopy() throws IOException {
		FileChannel inChannel = new FileInputStream(fileName1).getChannel();
		FileChannel outChannel = new FileOutputStream(fileName2).getChannel();

		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while (inChannel.read(buffer) != -1) {
			buffer.flip();
			outChannel.write(buffer);
			buffer.clear();
		}
	}

	@SuppressWarnings("resource")
	public static void TransferToDemo() throws IOException {
		FileChannel inChannel = new FileInputStream(fileName1).getChannel();
		FileChannel outChannel = new FileOutputStream(fileName3).getChannel();

		inChannel.transferTo(0, inChannel.size(), outChannel);
	}

	@SuppressWarnings("resource")
	public static void BufferToText() throws IOException {
		FileChannel ouChannel = new FileOutputStream(fileName1).getChannel();
		String encoding = System.getProperty("file.encoding");
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		System.out.println("Decoded using: " + encoding + ": " + Charset.forName(encoding).decode(buffer));

//		ouChannel.write(ByteBuffer.wrap("{\"name\":\"ywx\"}".getBytes("UTF-16BE")));
		ouChannel.write(ByteBuffer.wrap("{\"name\":\"ywx\"}".getBytes()));
		ouChannel.close();

		FileChannel inChannel = new FileInputStream(fileName1).getChannel();
		buffer.clear();
		inChannel.read(buffer);
		buffer.flip();
		System.out.println("BufferToText: read: " + buffer.asCharBuffer());

		ouChannel = new FileOutputStream(fileName2).getChannel();
		buffer = ByteBuffer.allocate(BSIZE);
		buffer.asCharBuffer().put("BufferToText2");
		ouChannel.write(buffer);
		ouChannel.close();
		inChannel = new FileInputStream(fileName2).getChannel();
		buffer.clear();
		inChannel.read(buffer);
		buffer.flip();
		System.out.println("BufferToText: read2: " + buffer.asCharBuffer());
	}

	public static void UTF8Demo() throws IOException {
		Charset charset = null;
		CharsetDecoder decoder = null;
		String charsetName = "UTF-8";
		int capacity = 10;

		charset = Charset.forName(charsetName);
		decoder = charset.newDecoder();

		String s = "客户端发送dsad德生科技电脑fdas上考虑迪士尼年少弗拉门发生ofjam打什么的即破发麦克 ‘；打， 饭哦按都";
		byte[] bytes = s.getBytes(charsetName);

		// 模拟接收的ByteBuffer size 10
		ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
		// 用于临时存放Bytebuffer转换后的字符
		CharBuffer charBuffer = CharBuffer.allocate(capacity);
		// 用于连接展示字符串
		StringBuilder sb = new StringBuilder();

		int i = 0;
		while (true) {
			byteBuffer.put(bytes[i]);
			i++;
			if (byteBuffer.remaining() == 0 || i == bytes.length) {
				byteBuffer.flip();
				CoderResult coderResult;
				if (i != bytes.length) {
					coderResult = decoder.decode(byteBuffer, charBuffer, false);
				} else {
					coderResult = decoder.decode(byteBuffer, charBuffer, true);
				}
				// 有错误
				if (coderResult.isError()) {
					coderResult.throwException();
				}
				charBuffer.flip();
				sb.append(charBuffer);
				charBuffer.clear();
				byteBuffer.compact();
			}
			// 退出循环
			if (i == bytes.length) {
				break;
			}
		}
		System.out.println(sb);
	}
}
