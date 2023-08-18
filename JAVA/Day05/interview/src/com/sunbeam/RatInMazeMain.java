package com.sunbeam;

import java.util.Objects;
import java.util.Stack;

public class RatInMazeMain {
	public static class Cell {
		int r, c;
		public Cell(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public int hashCode() {
			return Objects.hash(c, r);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Cell)) {
				return false;
			}
			Cell other = (Cell) obj;
			return c == other.c && r == other.r;
		}
	}
	public static boolean isValid(Cell cell, int[][] maze) {
		if(cell.r < 0 || cell.r >= maze.length)
			return false;
		if(cell.c < 0 || cell.c >= maze.length)
			return false;
		if(maze[cell.r][cell.c] == 1) // obstacle
			return false;
		return true;
	}
	public static boolean isMarked(Cell cell, boolean[][] marked) {
		return marked[cell.r][cell.c];
	}
	public static void mark(Cell cell, boolean[][] marked) {
		marked[cell.r][cell.c] = true;
	}
	
	public static boolean isReachable(int[][] maze, Cell rat, Cell cheese) {
		boolean[][] marked = new boolean[maze.length][maze.length]; // initial = false
		Stack<Cell> s = new Stack<>();
		s.push(rat);
		mark(rat, marked);
		while(!s.isEmpty()) {
			Cell cur = s.pop();
			if(cur.equals(cheese))
				return true;
			Cell[] neighbors = {
				new Cell(cur.r+1, cur.c),
				new Cell(cur.r-1, cur.c),
				new Cell(cur.r, cur.c+1),
				new Cell(cur.r, cur.c-1),
			};
			for(Cell neighbor:neighbors) {
				if(isValid(neighbor, maze) && !isMarked(neighbor, marked)) {
					s.push(neighbor);
					mark(neighbor, marked);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] maze = {
				{0, 1, 0, 1, 1},
				{0, 0, 0, 0, 0},
				{1, 0, 1, 0, 1},
				{0, 0, 1, 0, 0},
				{1, 0, 0, 1, 0}
		};
		Cell rat = new Cell(0,0);
		Cell cheese = new Cell(4,4);
		boolean success = isReachable(maze, rat, cheese);
		System.out.println("Is Reachable: " + success);
	}

}
