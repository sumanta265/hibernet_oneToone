package hibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String args[])
	{
		
		//Configuration cfg = new Configuration();   we can use configure class to configure our hibernate xml file or we can use standard service registery
		//cfg.configure("hibernate.cfg.xml");
		//SessionFactory factory = cfg.buildSessionFactory();
		
		StandardServiceRegistry ss = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ss).getMetadataBuilder().build();
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		
		Session session =factory.openSession();
		Transaction t=session.beginTransaction();
		Student s = new Student();
		//s.setId(111);
		s.setName("Sumanta");
		
        Address add= new Address();
        //add.setAddId(1);
		add.setStreet("park street");
		add.setState("wb");
		add.setPin("713208");
		s.setAddress(add);
		
		session.save(add);
		session.save(s);
		
		
		
		Student s1 = new Student();
		s1.setId(123);
		s1.setName("anwita");
		
		Address add1= new Address();
        add1.setAddId(2);
		add1.setStreet("Asansol");
		add1.setState("wb");
		add1.setPin("713223");
		s1.setAddress(add1);
		
		session.save(add1);
		session.save(s1);
		
		
		t.commit();
		int i=s.getId();
		Object o = session.get(Student.class, new Integer(i));
		Student v = (Student)o;

		Transaction tx = session.beginTransaction();
		session.delete(v);
		tx.commit();

		
		session.close();
		factory.close();
		System.out.println(s1+" got added");
	}
	
	
}
