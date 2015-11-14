/***********************************************
 * Author: Guangzhou Zeng
 * Date: 11/14/2015
 * 
 */

package spatialDB.Draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

class DrawPanel extends JPanel implements MouseListener{
	public Boolean isChecked=false; //when true, open the mouse listener
	int clickX=-1;
	int clickY=-1;
	public DrawPanel(){
		setBackground(Color.WHITE);
		addMouseListener(this);
	}
	public void paint(Graphics g){
		super.paint(g);
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
				int r=(int)(point[5]-point[1]);
				int x=(int)point[0]-r/2;
				int y=(int)point[3]-r/2;
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
		
		if(isChecked==true){
			//find lions
			String str="SELECT L.shape ";
			str+="FROM lion L, region R1 ";
			str+="WHERE R1.regi_id IN(";
			str+="SELECT R2.regi_id ";
			str+="FROM region R2 ";
			str+="WHERE SDO_CONTAINS(R2.shape,  ";
			str+="SDO_GEOMETRY( ";
			str+="	2001,NULL,NULL, ";
			str+="	SDO_ELEM_INFO_ARRAY(1,1,1), ";
			str+="	SDO_ORDINATE_ARRAY("+clickX+","+clickY+")))='TRUE' ";
			str+=") AND SDO_CONTAINS(R1.shape, L.shape)='TRUE'";
			
			//find ponds
			String str2="SELECT P.shape ";
			str2+="FROM pond P, region R1 ";
			str2+="WHERE R1.regi_id IN(";
			str2+="SELECT R2.regi_id ";
			str2+="FROM region R2 ";
			str2+="WHERE SDO_CONTAINS(R2.shape,  ";
			str2+="SDO_GEOMETRY( ";
			str2+="	2001,NULL,NULL, ";
			str2+="	SDO_ELEM_INFO_ARRAY(1,1,1), ";
			str2+="	SDO_ORDINATE_ARRAY("+clickX+","+clickY+")))='TRUE' ";
			str2+=") AND SDO_CONTAINS(R1.shape, P.shape)='TRUE'";
			
			
			Statement slt_check_lion, slt_check_pond;
			try {
				slt_check_lion=con.createStatement();
				slt_check_pond=con.createStatement();
				ResultSet check_lion_rs=slt_check_lion.executeQuery(str);
				ResultSet check_pond_rs=slt_check_pond.executeQuery(str2);
				
				while(check_lion_rs.next()){
					STRUCT st=(oracle.sql.STRUCT) check_lion_rs.getObject(1);
					JGeometry j_geom=JGeometry.load(st);
					double point[]=j_geom.getPoint();
					g.setColor(Color.RED);
					g.fillOval((int)point[0], (int)point[1], 5,5);
				}
				while(check_pond_rs.next()){
					STRUCT st=(oracle.sql.STRUCT) check_pond_rs.getObject(1);
					JGeometry j_geom=JGeometry.load(st);
					double point[]=j_geom.getOrdinatesArray();
					int r=(int)(point[5]-point[1]);
					int x=(int)point[0]-r/2;
					int y=(int)point[3]-r/2;
					g.setColor(Color.RED);
					g.fillOval(x, y, r, r);
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(isChecked==true){
			System.out.println("X: "+e.getX());
			System.out.println("Y: "+e.getY());
			clickX=e.getX();
			clickY=e.getY();
			repaint();
			validate();
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	    checkBtn.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(drawpanel.isChecked==true){
					drawpanel.isChecked=false;
					 drawpanel.repaint();
				}
				else 
					drawpanel.isChecked=true;
			}
	    });
	   
	    validate();
	}

	public static void main(String args[]) throws SQLException{
		//connectToAndQueryDatabase("chris","123");
		Draw draw=new Draw(517,583);
	}
}