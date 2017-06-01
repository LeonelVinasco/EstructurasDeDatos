package taller6;

//import javafx.scene.control.TreeTableView;

import java.io.*;
import java.util.*;

// object ของ Vertex
class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
    public void resetWeight() {
        minDistance = Double.POSITIVE_INFINITY;
    }
}

class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class Dijkstra
{
    public static void computePaths(Vertex source)
    {
        System.out.println("-------------- SHORTEST PATH COMPUTE PHASE -----------");
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll(); // ดึง head ของ queue ออกมา

            System.out.println("visited at vertices " + u.name);
            // Visit each edge exiting u
            for (Edge e : u.adjacencies) // ไล่ตามแต่ละ edge ของ vertex นั้นๆ
            {
                Vertex v = e.target;
                System.out.println("check at vertices " + v.name);
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight; // เอาผลรวม Weight เก่า + กับ Weight ใหม่
                if (distanceThroughU < v.minDistance) { // เช็คว่า เส้นทางไหม่ที่ไปถึง vertices ที่ u มี edge ไปถึงสั้นกว่า เส้นทางเก่าที่ vertices ปลายทางเก็บว่าสั้นที่สุดหรือไม่
                    System.out.println("Path from vertices " + u.name + " is shorter than old path");
                    vertexQueue.remove(v); // ลบ vertice v ซึ่งเป็น vertice ที่มีเส้นทางมาจาก u ที่เราตรวจสอบอยู่ ออกจาก queue ที่รอการตรวจสอบเพราะเราตรวจสอบแล้ว
                    v.minDistance = distanceThroughU ; // ใส่ minDiatance ใหม่เพราะเจอเส้นทางใหม่ที่สั้นกว่าแล้ว
                    v.previous = u; // เปลี่ยนเส้นทาง โดยให้มันเดินทางมาจากทางใหม่จาก vertice ที่เราตรวจสอบแล้วเจอว่าสั้นกว่าแทน
                    vertexQueue.add(v); // เอา v เป็น vertice ที่มีเส้นทางมาจาก u ใส่ลงใน queue เพื่อรอการตรวจสอบ
                }
            }
        }
    }

    /**
     *  Method นี้ใช้ในการสร้าง path return ออกไปโดยไล่จาก จุดสุดท้ายแล้ว ไล่ตาม linklist previous กลับไปจนถึงต้นทาง
     * @param target
     * @return
     */
    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous) // ไล่ใต่จาก จุดสุดท้าย(target) แล้วถอยกลับมาเรื่อยๆจนถึงจุดเริ่มต้น
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }

    public static double getWeight(Vertex start, Vertex target){
        double weight = .0;
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous){

        }
        return weight;
    }

    public static void main(String[] args) {

        Map<String,Vertex> vertices = new LinkedHashMap<String,Vertex>(); // ใส่ vertices เป็น LinkedHashMap เพื่อไล่หาทำการสร้าง ที่ต้องใช้ HashMap เพราะจะได้เรียก object จากชื่อของมันได้

        //READ CSV FOR CREATE NODE
        String csvFile = "input.csv";
        BufferedReader br = null;
        String line = ""; // CSV กั้นแต่ละ บรรทัดด้วยการไม่ใส่อะไร
        String cvsSplitBy = ","; // ตัวแยกข้อมูล

        try {
            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            String[] first_line_data = line.split(cvsSplitBy);
            for(String name : first_line_data){
                vertices.put( name, new Vertex(name));
            }
            // วนใส่ค่า adjacency
            for(Vertex vertice : vertices.values()) {
                ArrayList<Edge> adj = new ArrayList<Edge>();// array ของ edge ใช้ในการเก็บความสัมพันธ์ ของ vertice ต่างๆ
                if((line = br.readLine()) != null){
                    String[] weight_data = line.split(cvsSplitBy); // กำหนด comma เป้นตัวแบ่งข้อมูล
                    if(weight_data.length == vertices.size()){
                        for(int edge_c = 0;edge_c < weight_data.length;edge_c++){
                            Vertex edge_vertex = (new ArrayList<Vertex>(vertices.values())).get(edge_c);
                            if(Double.parseDouble(weight_data[edge_c]) > 0){
                                System.out.println(" put edge "+ edge_vertex + " link form vertice " + vertice.name  + " with weight = " + weight_data[edge_c]);
                                adj.add( new Edge( edge_vertex ,Double.parseDouble(weight_data[edge_c]))); //สร้าง Edge เชื่อมต่อกับ vertice ปัจจุบัน
                            }
                        }
                        Edge[] arr_from_adj = new Edge[adj.size()]; // สร้าง Array มารอรับ
                        adj.toArray(arr_from_adj); // แปลง ArrayList เป็น Array
                        vertice.adjacencies = arr_from_adj; //ใส่ adjacencies ให้ vertice

                    }else{
                        System.out.println("Warning :: your csv has data that out of bound !!");
                        break;
                    }
                }else{
                    System.out.println("Your CSV files have some thing wrong. maybe it's lost detail or wrong format");
                    break;
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }

        Vertex start = vertices.get("a");
        Vertex target = vertices.get("z");

        Scanner input = new Scanner(System.in);
        System.out.println("Choose mode for execute Dijkstra shortest path finder.");
        System.out.println("1 : find path from a to z");
        System.out.println("2 : Choose start vertice and target vertice by yourself.");
        int mode = Integer.parseInt(input.nextLine()); // get user mode;
        if (mode == 1) {
            // it's default
        } else if (mode == 2) {
            System.out.println("Choose Start vertice");
            start =  vertices.get(input.nextLine());

            System.out.println("Choose Target path");
            target = vertices.get(input.nextLine());
        } else {
            System.out.println("You choose wrong number . I'll choose 1 by default.");
        }
        computePaths(start); // กำหนดจุดเริ่มต้น
        System.out.println("Distance to " + target.name + ": " + target.minDistance);
        List<Vertex> path = getShortestPathTo(target);
        System.out.println("Path: " + path);

    }
}