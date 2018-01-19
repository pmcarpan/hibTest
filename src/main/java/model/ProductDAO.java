package model;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAO {

	private Transaction t;
	
	public boolean insertProduct(Product p) {
		try (Session s = new DBConfig().getSess()) {
			t = s.beginTransaction();
			s.save(p);
			t.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		}
		return true;
	}
	
}
