package manages.jdbc;


public interface ManagerDao {
  public void SavaManager(Manager user)throws Exception;
public Manager find(String name)throws Exception;
public void DeleteManager(String name)throws Exception;
}
