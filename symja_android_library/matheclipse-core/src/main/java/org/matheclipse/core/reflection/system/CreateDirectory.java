package org.matheclipse.core.reflection.system;

import com.gx.common.io.Files;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IStringX;
import org.matheclipse.parser.client.math.MathException;

import java.io.File;
import java.io.IOException;

import ch.ethz.idsc.tensor.io.Extension;
import ch.ethz.idsc.tensor.io.Filename;
import ch.ethz.idsc.tensor.io.ImageFormat;

/**
 * Create a default temporary directory
 *
 */
public class CreateDirectory extends AbstractEvaluator {

	public CreateDirectory() {
	}

	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) throws MathException {
		if (Config.isFileSystemEnabled(engine)) {
			if (ast.isAST0()) {
				File tempDir = Files.createTempDir();
				return F.stringx(tempDir.toString());
			} else if (ast.isAST1() && ast.arg1() instanceof IStringX) {
			}
		}
		return F.NIL;
	}

	/**
	 * See the documentation of {@link CsvFormat}, {@link ImageFormat}, {@link MatlabExport}, and {@link ObjectFormat}
	 * for information on how tensors are encoded in the respective format.
	 * 
	 * @param file
	 *            destination
	 * @param tensor
	 * @throws IOException
	 */
	public static void of(File file, IAST tensor) throws IOException {
		Filename filename = new Filename(file);
		// if (filename.hasExtension("csv"))
		// Files.write(file.toPath(), (Iterable<String>) CsvFormat.of(tensor)::iterator);
		// else
		Extension extension = filename.extension();
		if (extension.equals(Extension.JPG)) {
			// TODO: 28-Oct-18  implement Image IO
//			ImageIO.write(ImageFormat.jpg(tensor), "jpg", file);
		}
		// else if (filename.hasExtension("m"))
		// Files.write(file.toPath(), (Iterable<String>) MatlabExport.of(tensor)::iterator);
		if (extension.equals(Extension.PNG)) {
			// TODO: 28-Oct-18  implement Image IO
//			ImageIO.write(ImageFormat.of(tensor), "png", file);
		}
		// else if (filename.hasExtension("tensor"))
		// object(file, tensor);
		else
			throw new RuntimeException(file.toString());
	}
}
