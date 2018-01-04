/* ESE 554
 * Pradyoth Rao
 * 13.1 Program to implement BFS algorithm for graphs with 9 vertices and 12 edges
 */
class GraphQueue
{
	private final int SIZE = 20;
	private int[] que;
	private int front;
	private int rear;
	
	public GraphQueue()
	{
		que = new int[SIZE];
		front = 0;
		rear = -1;
	}
	
	public void insert(int j) 
	{
		if(rear == SIZE - 1)
			rear = -1;
		que[++rear] = j;
	}
	
	public int remove()	
	{
		int temp = que[front++];
		if(front == SIZE)
			front = 0;
		return temp;
	}
	
	public boolean isEmpty()
	{
		return (rear + 1 == front || (front+SIZE-1 == rear) );
	}
} 

class Vertex
{
	public char label;	//label (e.g. 'A')
	public boolean wasVisited;
	
	public Vertex(char lab)
	{
		label = lab;
		wasVisited = false;
	}
	
} 

class BFSGraph
{
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; 
	private int adjMat[][];	
	private int nVerts;	
	private GraphQueue theQueue;
	
	public BFSGraph()
	{
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j = 0; j<MAX_VERTS; j++)			
			for(int k = 0; k<MAX_VERTS; k++)		
				adjMat[j][k] = 0;
		theQueue = new GraphQueue();
	}
	
	public void addVertex(char lab)
	{
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end)
	{
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label);
	}
	
	public void bfs()
	{
		vertexList[0].wasVisited = true;
		displayVertex(0);
		theQueue.insert(0);
		int v2;
		
		while(!theQueue.isEmpty())
		{
			int v1 = theQueue.remove();
			while( (v2=getAdjUnvisitedVertex(v1)) != -1)
			{
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				theQueue.insert(v2);
			}
		}
		
		for(int j = 0; j < nVerts; j++)
			vertexList[j].wasVisited = false;
	} //end bfs()
	
	//displays the minimum spanning tree made from a BFS
	public void bfMinSpanTree()
	{
		vertexList[0].wasVisited = true;
		theQueue.insert(0);
		int v2;
		
		while(!theQueue.isEmpty())
		{
			int v1 = theQueue.remove();
			while( (v2=getAdjUnvisitedVertex(v1)) != -1)
			{
				vertexList[v2].wasVisited = true;
				displayVertex(v1);
				displayVertex(v2);
				System.out.print("|");
				theQueue.insert(v2);
			}
		}
		
		for(int j = 0; j < nVerts; j++)
			vertexList[j].wasVisited = false;
	} //end bfMinSpanTree()
	
	//returns an unvisited vertex adjacent to v
	public int getAdjUnvisitedVertex(int v)
	{
		for(int j = 0; j < nVerts; j++)
			if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j;
		return -1;
	}
	
} //end class Graph

class BFSApp
{
	public static void main(String[] args)
	{
		BFSGraph g = new BFSGraph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addVertex('G');
		g.addVertex('H');
		g.addVertex('I');
		
		g.addEdge(0, 1);
		g.addEdge(1, 7);
		g.addEdge(7, 8);
		g.addEdge(1, 8);
		g.addEdge(1, 2);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(3, 6);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		
		System.out.print("Visits: ");
		g.bfs();
		System.out.println();
		
		System.out.println("Minimum Spanning Tree of Graph");
		g.bfMinSpanTree();
		System.out.println();
		
	}
}
