/*
 * @(#)Monitor.java
 */
package jp.ac.kobe_u.cs.cream;

import java.util.ArrayList;
import java.util.IdentityHashMap;

/**
 * Monitor class.
 *
 * @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 * @version 1.4
 * @see Solver
 * @see ParallelSolver
 * @since 1.0
 */
public class Monitor {
    private static final long serialVersionUID = 2455481861250231140L;
    public int topMargin = 100;
    public int botMargin = 50;
    public int leftMargin = 50;
    public int rightMargin = 50;
    private long startTime;
    private ArrayList<Solver> solvers;
    private IdentityHashMap<Solver, Integer[]> solverData;
    private int current_x;

    //	private Image image = null;
    private int xmin;
    private int xmax;
    private int ymin;
    private int ymax;
    private long prevPaintTime;
    private double xscale;

    private double yscale;
/*
    private Color[] colors = {
			Color.RED, Color.BLUE, new Color(0, 128, 0),
			new Color(0, 128, 128), Color.MAGENTA, Color.GREEN,
			new Color(128, 128, 0), Color.PINK };*/

    public Monitor() {
    /*	init();
		setSize(800, 600);
		setResizable(true);
		MenuItem close = new MenuItem("Close");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		MenuItem quit = new MenuItem("Quit");
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Menu menu = new Menu("Window");
		menu.add(close);
		menu.add(quit);
		MenuBar mb = new MenuBar();
		mb.add(menu);
		setMenuBar(mb);
		setBackground(Color.WHITE);
		validate();
		setVisible(true);*/
    }

    public synchronized void init() {
        startTime = System.currentTimeMillis();
        solvers = new ArrayList<Solver>();
        solverData = new IdentityHashMap<Solver, Integer[]>();
        current_x = 0;
        setX(0, 10);
        ymin = Integer.MAX_VALUE;
        ymax = Integer.MIN_VALUE;
    }

    public synchronized void setX(int xmin, int xmax) {
        this.xmin = Math.max(0, xmin);
        this.xmax = Math.max(this.xmin + 60, xmax);
    }

    public synchronized void add(Solver solver) {
        solvers.add(solver);
    }

    public synchronized void addData(Solver solver, int y) {
        long t0 = System.currentTimeMillis();
        int x = (int) ((t0 - startTime) / 1000);
        int j = x - xmin;
        if (x < xmin)
            return;
        if (x > xmax) {
            xmax = xmin + 4 * j / 3;
            if (xmax % 60 != 0)
                xmax += 60 - xmax % 60;
        }
        current_x = Math.max(current_x, x);
        ymin = Math.min(ymin, y);
        ymax = Math.max(ymax, y);
        Integer[] data = solverData.get(solver);
        if (data == null) {
            data = new Integer[xmax - xmin];
            solverData.put(solver, data);
        }
        if (j >= data.length) {
            Integer[] newData = new Integer[4 * j / 3];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
            solverData.put(solver, data);
        }
        data[j] = new Integer(y);
    }
}
