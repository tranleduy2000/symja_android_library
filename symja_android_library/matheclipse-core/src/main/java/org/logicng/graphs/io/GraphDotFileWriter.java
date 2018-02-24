///////////////////////////////////////////////////////////////////////////
//                   __                _      _   ________               //
//                  / /   ____  ____ _(_)____/ | / / ____/               //
//                 / /   / __ \/ __ `/ / ___/  |/ / / __                 //
//                / /___/ /_/ / /_/ / / /__/ /|  / /_/ /                 //
//               /_____/\____/\__, /_/\___/_/ |_/\____/                  //
//                           /____/                                      //
//                                                                       //
//               The Next Generation Logic Library                       //
//                                                                       //
///////////////////////////////////////////////////////////////////////////
//                                                                       //
//  Copyright 2015-2018 Christoph Zengler                                //
//                                                                       //
//  Licensed under the Apache License, Version 2.0 (the "License");      //
//  you may not use this file except in compliance with the License.     //
//  You may obtain a copy of the License at                              //
//                                                                       //
//  http://www.apache.org/licenses/LICENSE-2.0                           //
//                                                                       //
//  Unless required by applicable law or agreed to in writing, software  //
//  distributed under the License is distributed on an "AS IS" BASIS,    //
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or      //
//  implied.  See the License for the specific language governing        //
//  permissions and limitations under the License.                       //
//                                                                       //
///////////////////////////////////////////////////////////////////////////

package org.logicng.graphs.io;

import org.logicng.graphs.datastructures.Graph;
import org.logicng.graphs.datastructures.Node;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A dot file writer for a graph.  Writes the internal data structure of the formula to a dot file.
 * @version 1.2
 * @since 1.2
 */
public class GraphDotFileWriter {

  /**
   * Private constructor.
   */
  private GraphDotFileWriter() {
    // Intentionally left empty.
  }

  /**
   * Writes a given formula's internal data structure as a dimacs file.
   * @param fileName the file name of the dimacs file to write
   * @param graph    the graph
   * @param <T>      the type of the graph content
   * @throws IOException if there was a problem writing the file
   */
  public static <T> void write(final String fileName, final Graph<T> graph) throws IOException {
    write(new File(fileName.endsWith(".dot") ? fileName : fileName + ".dot"), graph);
  }

  /**
   * Writes a given graph's internal data structure as a dot file.
   * @param file  the file of the dot file to write
   * @param graph the graph
   * @param <T>   the type of the graph content
   * @throws IOException if there was a problem writing the file
   */
  public static <T> void write(final File file, final Graph<T> graph) throws IOException {
    final StringBuilder sb = new StringBuilder("strict graph {\n");

    Set<Node<T>> doneNodes = new LinkedHashSet<>();
    for (Node<T> d : graph.nodes()) {
      for (Node<T> n : d.neighbours())
        if (!doneNodes.contains(n))
          sb.append("  ").append(d.content()).append(" -- ").append(n.content()).append("\n");
      doneNodes.add(d);
    }
    for (Node<T> d : graph.nodes()) {
      if (d.neighbours().isEmpty()) {
        sb.append("  ").append(d.content()).append("\n");
      }
    }
    sb.append("}");

    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), Charset.forName("UTF-8")))) {
      writer.append(sb);
      writer.flush();
    }
  }
}
