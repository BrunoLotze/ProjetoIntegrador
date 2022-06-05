import java.sql.*;
import java.util.Date;



public class SQL {

    // Date d = new Date();
    // int a = d.toLocalTime().toSecondOfDay();

  private String usuario = "root";
  // Trocar a senha do banco
  private String host = "localhost";
  private String porta = "3306";
  private String bd = "game";

  //String nomes and id
  private static int idjogador;
  private String playername;
  private int numvi;
  private int numper;

  public Connection getConnection() {
      Connection con = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://" + host + ":" + porta + "/" + bd,
          usuario,
          "");
      System.out.println("Xampp Conectado!");
      return con;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  public void setidjogador(int idjogador){this.idjogador = idjogador;}
  public static int getidjogador(){return idjogador;}
  public void setplayername(String playername){this.playername = playername;}
  public String getplayername(){return playername;}

  public void setnumvi(int numvi){this.numvi = numvi;}
  public int getnumvi(){return numvi;}

  public void setnumper(int numper){this.numper = numper;}
  public int getnumper(){return numper;}


  public void closeConnection() {
    Connection con = getConnection();
    if (con != null) {
      try {
        con.close();
        System.out.println("End");
      } catch (SQLException e) {
        System.out.println("Wrong End");
      }
    }
  }

  //set user
  public void createUser(String username){
     if(username.isEmpty()){
      
    }
    else{

      String query = "INSERT INTO reg (Nome, Nump, NumV) VALUES ('"+ username +"', 0, 0)";
      System.out.println(username);
      try(Connection con  = getConnection();
      PreparedStatement ps =  con.prepareStatement(query);){
        ps.execute();
        //seta o playername
        setplayername(username);
        
      }catch(Exception e){
        e.printStackTrace();
        System.out.println("Erro ao cadastro");
        
      }
      
    }

  }

  //gets sql


  // //get points
  // public int getpp(String){
  //   String getpoints = "SELECT (NumV) FROM REG WHERE id = '"+ getidjogador() +"'";
  //   try(Connection con = getConnection(); PreparedStatement ps =  con.prepareStatement(getpoints);){
  //     if(rs.next()){
  //       System.out.println(rs.getInt(1))
  //     }
  //   }
  // }

  //id sql
  public void getid(String username){
   String getid = "SELECT (id) FROM reg WHERE Nome = '"+ username +"'";
   try(Connection con  = getConnection();
    PreparedStatement ps =  con.prepareStatement(getid);){
      ResultSet rs = ps.executeQuery(getid);
      if(rs.next()){
        System.out.println(rs.getInt(1));
        setidjogador(rs.getInt(1));
        
      }
      else{
        System.out.println("Query Vazia");
        
      }
    }
    catch(SQLException e){
      System.out.println("Query nao executou");
      e.printStackTrace();
      
    } 
  }

  //end gets sql

  public void setpp(int i){
      if(i == 0){

        

      }else{

        String query = "UPDATE reg set NumV = NumV + 1 WHERE id = "+ i +"";
        String x = "SELECT NumV FROM reg WHERE id = "+ i + "";

        try(Connection con  = getConnection(); PreparedStatement ps = con.prepareStatement(query); PreparedStatement px = con.prepareStatement(x);){
          ps.execute();
          ResultSet pp = px.executeQuery(x);
          if (pp.next()) {  
          setnumvi(pp.getInt(1));
          System.out.println("Pontuacao Correta: " + getnumvi());

          }
          else{

            System.out.println("Query Vazia");
            

          }
        }catch(Exception e){

          e.printStackTrace();
          System.out.println("Erro ao pontuar acerto");
         

      }
    }

  }


 //setpd(getidjogador);

  public void setpd(int i){
      if(i == 0){

        

      }else{

        String query = "UPDATE reg set Nump = Nump + 1 WHERE id = "+ i +"";
        String x = "SELECT Nump FROM reg WHERE id = "+ i + "";

        try(Connection con  = getConnection(); PreparedStatement ps = con.prepareStatement(query); PreparedStatement px = con.prepareStatement(x);){
          ps.execute();
          ResultSet pp = px.executeQuery(x);
          if (pp.next()) {  
          setnumper(pp.getInt(1));
          System.out.println("Pontuacao De Erros: " + getnumper());
       

          }
          else{

            System.out.println("Query Vazia");
        

          }
        }catch(Exception e){

          e.printStackTrace();
          System.out.println("Erro ao pontuar erro");
        

      }
    }

  }

}