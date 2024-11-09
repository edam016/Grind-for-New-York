public class Graph{

    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected){
        this.vertices = new ArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public Vertex addVertex(String data){
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return new Vertex;
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight){
        if(!this.isWeighted){
            weight = null;
        }
        vertex1.addEdge(vertex2, weight);
        if(!this.isDirected){
            //bidirectional
            vertex2.addEdge(vertex1, weight);
        }
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2){
        vertex1.removeEdge(vertex2);
        if(!this.isDirected){
            vertex2.removeEdge(vertex1);
        }
    }

    public void removeVertex(Vertex vertex){
        this.vertices.remove(vertex);
    }

    public ArrayList<Vertex> getVertices(){
        return this.vertices;
    }

    public boolean isWeighted(){
        return this.isWeighted;
    }

    public boolean isDirected(){
        return this.isDirected;
    }

    public Vertex getVertexByValue(String value){
        for(Vertex v: this.vertices){
            if(v.getData() == value){
                return v; 
            }
        }
    }

    public void print()
    public static void main(String[] args){
        
    }
}