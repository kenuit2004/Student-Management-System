import java.sql.*;
import java.util.*;
public class JDBCStudentManagementSystem 
{
		private static Connection getConnection() throws SQLException
		{
			String a="jdbc:mysql://localhost:3306/kenuit_db";
			String b="root";
			String c="pasword";
			return DriverManager.getConnection(a,b,c);
		}
		private static void insertStudent(int id,String name) throws SQLException
		{
			String a="INSERT INTO STUDENT(Id,Name) VALUES(?,?)";
			try(Connection con=getConnection();
					PreparedStatement pre=con.prepareStatement(a);
			)
			{
				pre.setInt(1,id);
				pre.setString(2,name);
				int row=pre.executeUpdate();
				System.out.println(row+" Student is Inserted");
			}
		}
		private static void updateStudent(int id,String name) throws SQLException
		{
			String a="UPDATE STUDENT SET NAME=? WHERE ID=?";
			try(Connection con=getConnection();
					PreparedStatement pre=con.prepareStatement(a);
			)
			{
				pre.setString(1,name);
				pre.setInt(2,id);
				int row=pre.executeUpdate();
				if(row>0)
				{
					System.out.println("Successfully Updated");
				}
				else
				{
					System.out.println("Student Id Not Found");
				}
			}
		}
		private static void deleteStudent(int id) throws SQLException
		{
			String a="DELETE FROM STUDENT WHERE ID=?";
			try(Connection con=getConnection();
					PreparedStatement pre=con.prepareStatement(a);
			)
			{
				pre.setInt(1,id);
				int row=pre.executeUpdate();
				if(row>0)
				{
					System.out.println("Successfully Deleted");
				}
				else
				{
					System.out.println("Student Id Not Found");
				}
			}
		}
		private static void retrieveStudent() throws SQLException
		{
			String a="SELECT * FROM STUDENT";
			try(Connection con=getConnection();
					PreparedStatement pre=con.prepareStatement(a);
					ResultSet res=pre.executeQuery();
			)
			{
				while(res.next())
				{
					System.out.println("Id:"+res.getInt("Id")+" "+"Name:"+res.getString("Name"));
				}
			}
		}
		public static void main(String[] args) 
		{
			try(Scanner sc=new Scanner(System.in))
			{
				while(true)
				{
					System.out.println("Student Management System");
					System.out.println("1.Insert The Student");
					System.out.println("2.Update The Student");
					System.out.println("3.Delete The Student");
					System.out.println("4.Retrieve The Student");
					System.out.println("5.Exit");
					System.out.print("Enter the Choice:");
					int choice=sc.nextInt();
					switch(choice)
					{
					    case 1:
					    {
					    	System.out.print("Enter the Student Id:");
					    	int id=sc.nextInt();
					    	System.out.print("Enter The Student Name:");
					    	String name=sc.next();
					    	insertStudent(id,name);
					    	break;
					    }
					    case 2:
					    {
					    	System.out.print("Enter the Student Id:");
					    	int id=sc.nextInt();
					    	System.out.print("Enter The Student Name:");
					    	String name=sc.next();
					    	updateStudent(id,name);
					    	break;
					    }
					    case 3:
					    {
					    	System.out.print("Enter the Student Id:");
					    	int id=sc.nextInt();
					    	deleteStudent(id);
					    	break;
					    }
					    case 4:
					    {
					    	retrieveStudent();
					    	break;
					    }
					    case 5:
					    {
					    	System.out.println("Existing the Student Management System");
					    	return;
					    }
					    default:
					    {
					    	System.out.println("Invalid Choice Entered.");
					    	break;
					    }
					}
				}
			}
			catch(SQLException e)
			{
				  e.printStackTrace();
			}
	}
}
