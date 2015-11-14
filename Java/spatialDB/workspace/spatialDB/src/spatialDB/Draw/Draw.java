package spatialDB.Draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;


class Region{
	public String regi_id;
	public int vertice;
	public int[] shape;
	Region(String regi_id, int vertice, int[] shape){
		this.regi_id=regi_id;
		this.vertice=vertice;
		this.shape=shape;
	}
}

class Lion{
	
}

class DrawPanel extends JPanel{
	public DrawPanel(){
		setBackground(Color.WHITE);
	}
	public void paint(Graphics g){
		//draw region
		Connection con = null;
		try {
			con = DriverManager.getConnection(
				       "jdbc:oracle:thin:@localhost:1521:xe",
				        "chris",
				         "123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//draw pond
		Statement slt_pond;
		try{
			slt_pond=con.createStatement();
			ResultSet pond_rs=slt_pond.executeQuery("SELECT shape FROM pond");
			
			while(pond_rs.next()){
				STRUCT st=(oracle.sql.STRUCT) pond_rs.getObject(1);
				JGeometry j_geom = JGeometry.load(st);
				double point[]=j_geom.getOrdinatesArray();
				int x=(int)point[0];
				int y=(int)point[3];
				int r=(int)(point[5]-point[1]);
				g.setColor(Color.BLACK);
				g.drawOval(x, y, r, r);
				g.setColor(Color.blue);
				g.fillOval(x, y, r, r);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		//draw lion
		Statement slt_lion;
		try {
			slt_lion = con.createStatement();
			ResultSet lion_rs = slt_lion.executeQuery("SELECT shape FROM lion");

			while (lion_rs.next()) {
		    	STRUCT st = (oracle.sql.STRUCT) lion_rs.getObject(1);
		    	JGeometry j_geom = JGeometry.load(st);
		    	double point[]=j_geom.getPoint();
		    	g.setColor(Color.GREEN);
		    	g.fillOval((int)point[0], (int)point[1], 5, 5);
		    	/*for(int i=0;i<point.length;i++){
		    		System.out.print(point[i]+" ");
		    	}
		    	System.out.println();*/
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement slt_region;
		try {
			slt_region=con.createStatement();
			ResultSet regi_rs=slt_region.executeQuery("SELECT shape FROM region");
			
			while(regi_rs.next()){
				STRUCT st=(oracle.sql.STRUCT) regi_rs.getObject(1);
				JGeometry j_geom=JGeometry.load(st);
				double point[]=j_geom.getOrdinatesArray();
				int xPoints[]=new int[4];
				int yPoints[]=new int[4];
				int j=0,k=0;
				for(int i=0;i<point.length-2;i++){
					if(i%2==0)
						xPoints[j++]=(int)point[i];
					else yPoints[k++]=(int)point[i];
				}
				g.setColor(Color.BLACK);
				g.drawPolygon(xPoints, yPoints, 4);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		/*int[] x=new int[]{400,500,500,400};
		int[] y=new int[]{0,0,100,100};
		g.drawPolygon(x,y,4);
		
		//draw pond
		g.drawOval(220, 430, 15, 15);
		g.setColor(Color.BLUE);
		g.fillOval(220, 430, 15, 15);
		
		//draw lion
		g.setColor(Color.GREEN);
		g.fillOval(350, 50, 5, 5);
		g.fillOval(355, 190, 5, 5);
		g.fillOval(30, 210, 5, 5);*/
		
		
		
		//g.drawPolygon();
	}
}


public class Draw extends JFrame{
	
	public Draw(int width, int height){
		setSize(width,height);
		setTitle("Spatial View");
		
		//always show in the middle of the screen
		Toolkit kit= Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int x=(screenSize.width-width)/2;
        int y=(screenSize.height-height)/2;
        setLocation(x,y);
		
        setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		Container c=getContentPane();
	    
	    JPanel checkPane = new JPanel();
	    final DrawPanel drawpanel=new DrawPanel(); 
	    
	    JCheckBox checkBtn=new JCheckBox("show lions and ponds in the selected region");
	    checkPane.add(checkBtn);
	    
	    c.add(checkPane,BorderLayout.NORTH);
	    c.add(drawpanel,BorderLayout.CENTER);

	    validate();
	}
	/*public static void connectToAndQueryDatabase(String username, String password) throws SQLException {
	    Connection con = DriverManager.getConnection(
	       "jdbc:oracle:thin:@localhost:1521:xe",
	        username,
	         password);
	    Statement stmt = con.createStatement();
	    ResultSet lion_rs = stmt.executeQuery("SELECT lion_id FROM lion");

	    while (lion_rs.next()) {
	        String x = lion_rs.getString("lion_id");
	        System.out.println(x);
	    }
	    
	    Statement statement=con.createStatement();
	    
	    ResultSet rs2 = statement.executeQuery("SELECT shape FROM region");
	    while (rs2.next()) {
	    	//convert STRUCT into geometry
	    	STRUCT st = (oracle.sql.STRUCT) rs2.getObject(1);
	    	JGeometry j_geom = JGeometry.load(st);
	    	//double point[]=j_geom.getPoint();
	    	double point[]=j_geom.getOrdinatesArray();
	    	for(int i=0;i<point.length;i++){
	    		System.out.print(point[i]+" ");
	    	}
	    	System.out.println();
		} 
	}*/
	
	public static void main(String args[]) throws SQLException{
		//connectToAndQueryDatabase("chris","123");
		/*int data[][]={
			{0,0,150,0,100,100,0,100},
			{150,0,250,0,300,150,100,100},
			{250,0,400,0,400,100,300,150},
			{400,0,500,0,500,100,400,100},
			{400,100,500,100,500,250,400,200},
			{300,150,400,100,400,200,250,250},
			{100,100,300,150,250,250,150,250},
			{0,100,100,100,150,250,0,250},
			{0,250,150,250,150,400,0,350},
			{150,250,250,250,300,350,150,400},
			{250,250,400,200,400,350,300,350},
			{400,200,500,250,500,350,400,350},
			{400,350,500,350,500,500,400,500},
			{300,350,400,350,400,500,300,500},
			{150,400,300,350,300,500,150,500},
			{0,350,150,400,150,500,0,500}
		};
		Region[] region=new Region[16];
		for(int i=0;i<data.length;i++){
			region[i]=new Region("R"+i,4,data[i]);
			//region[i].regi_id=new String("R1");
			//region[i].vertice=4;
			//region[i].shape=data[i];
		}
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data[i].length;j++){
				System.out.println(region[i].regi_id+" "+region[i].vertice+" "+region[i].shape[j]+" ");
			}
			System.out.println("\n");
		}*/
		
		
		Draw draw=new Draw(600,600);
		
		
	}
}