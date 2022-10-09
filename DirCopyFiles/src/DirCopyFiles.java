import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;

public class DirCopyFiles {

	public static void main(String[] args) throws IOException {

		System.out.println("START");

		Set<File> all = new HashSet<File>();
		getAllFileAndFolder(new File("f://Music"), all);

		for (File file : all) {
			if (file.exists()) {
				processDir(file);
				System.out.println(file);
			}
		}

		System.out.println("FINISH");

	}

	private static void processDir(File dir) throws IOException {

		if (!dir.isDirectory()) {
			throw new IOException("Not a directory " + dir);
		}

		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];

			if (file.isDirectory()) {
			} else {
				Object extractFileName;
				boolean isExtractedFileName = extractFileName(file);
				if (!isExtractedFileName) {
					throw new IOException("Unable to extract file" + file);
				}
			}
		}
	}

	private static boolean extractFileName(File sourceFile) throws FileNotFoundException {
		String c1 = sourceFile.toString();
		String d1 = c1.replaceAll(Matcher.quoteReplacement("\\"), "#");
		String[] listSt = d1.split("#");

		for (String sourceElement : listSt) {
			if (sourceElement.contains(".")) {
				copyFile(c1, "f:\\allFilesInMusic\\" + sourceElement);
				return true;
			}
		}
		return false;
	}

	private static void copyFile(String path1, String path2) throws FileNotFoundException{

		InputStream inStream = null;
		OutputStream outStream = null;

		try {
			File afile = new File(path1);
			File bfile = new File(path2);

			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);

			byte[] buffer = new byte[1024];

			int length;

			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}
			inStream.close();
			outStream.close();
			System.out.println(path1 + " plik zapisany");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void getAllFileAndFolder(File folder, Set<File> all) {

		if (folder.isFile()) {
			return;
		}
		all.add(folder);

		for (File file : folder.listFiles()) {

			// all.add(file);
			if (file.isDirectory()) {
				all.add(file);
				getAllFileAndFolder(file, all);
			}
		}

	}

}