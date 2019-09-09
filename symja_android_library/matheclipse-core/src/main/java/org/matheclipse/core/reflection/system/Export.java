package org.matheclipse.core.reflection.system;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.builtin.IOFunctions;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;

/**
 * Export some data from file system.
 *
 */
public class Export extends AbstractEvaluator {


    public Export() {
    }


    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
        if (Config.isFileSystemEnabled(engine)) {
//
//			if (!(ast.arg1() instanceof IStringX)) {
//				throw new WrongNumberOfArguments(ast, 1, ast.argSize());
//			}
//			IStringX arg1 = (IStringX) ast.arg1();
//			Extension format = Extension.exportFilename(arg1.toString());
//			if (ast.size() == 4) {
//				if (!(ast.arg3() instanceof IStringX)) {
//					throw new WrongNumberOfArguments(ast, 3, ast.argSize());
//				}
//				// format = ((IStringX) ast.arg3()).toString();
//				format = Extension.exportExtension(((IStringX) ast.arg3()).toString());
//			}
//			IExpr arg2 = ast.arg2();
//			FileWriter writer = null;
//			try {
//				writer = new FileWriter(arg1.toString());
//				if (arg2 instanceof DataExpr && arg2.head() == F.Graph) {
//					graphExport(((DataExpr<Graph>) arg2).toData(), writer, format);
//					return arg1;
//				}
//
//				if (format.equals(Extension.TABLE)) {
//					int[] dims = arg2.isMatrix();
//					if (dims != null) {
//						for (int j = 0; j < dims[0]; j++) {
//							IAST rowList = (IAST) arg2.getAt(j + 1);
//							for (int i = 1; i <= dims[1]; i++) {
//								if (rowList.get(i).isReal()) {
//									writer.append(rowList.get(i).toString());
//								} else {
//									writer.append("\"");
//									writer.append(rowList.get(i).toString());
//									writer.append("\"");
//								}
//								if (i < dims[1]) {
//									writer.append(" ");
//								}
//							}
//							writer.append("\n");
//						}
//						return arg1;
//					} else {
//						if (arg2.isList()) {
//
//						}
//					}
//				} else if (format.equals(Extension.DAT)) {
//					File file = new File(arg1.toString());
//					com.google.common.io.Files.write(arg2.toString(), file, Charset.defaultCharset());
//					return arg1;
//				} else if (format.equals(Extension.WXF)) {
//					File file = new File(arg1.toString());
//					byte[] bArray = WL.serialize(arg2);
//					com.google.common.io.Files.write(bArray, file);
//					return arg1;
//				}
//
//			} catch (IOException ioe) {
//				return engine.printMessage("Export: file " + arg1.toString() + " not found!");
//			} catch (Exception ex) {
//				return engine.printMessage("Export: file " + arg1.toString() + " - " + ex.getMessage());
//			} finally {
//				if (writer != null) {
//					try {
//						writer.close();
//					} catch (IOException e) {
//					}
//				}
//			}
            throw new UnsupportedOperationException();
        }
        return F.NIL;
    }

//    void graphExport(Graph<IExpr, DefaultEdge> g, Writer writer, Extension format)
//            throws ExportException, UnsupportedEncodingException {
//        switch (format) {
//            case DOT:
//                DOTExporter<IExpr, DefaultEdge> dotExporter = new DOTExporter<>(new IntegerComponentNameProvider<>(), null,
//                        null, null, null);
//                dotExporter.putGraphAttribute("overlap", "false");
//                dotExporter.putGraphAttribute("splines", "true");
//
//                dotExporter.exportGraph(g, writer);
//                return;
//            case GRAPHML:
//                GraphExporter<IExpr, DefaultEdge> graphMLExporter = new GraphMLExporter<>();
//                graphMLExporter.exportGraph(g, writer);
//                return;
//            default:
//        }
//
//        // DEFAULT: return CSV file
//        CSVExporter<IExpr, DefaultEdge> exporter = new CSVExporter<IExpr, DefaultEdge>(nameProvider,
//                org.jgrapht.io.CSVFormat.EDGE_LIST, ';');
//        exporter.exportGraph(g, writer);
//    }

    public int[] expectedArgSize() {
        return IOFunctions.ARGS_2_3;
    }
}
