package equipment.jdbc;

import java.util.List;


public interface EquipmentDao {
  public void SaveEquipment(Equipment user)throws Exception;
public List<Equipment> find(String name)throws Exception;
public void DeleteEquipment(String name)throws Exception;
}
