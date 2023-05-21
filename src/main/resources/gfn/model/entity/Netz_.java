package gfn.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-05-21T11:43:35.022+0200")
@StaticMetamodel(Netz.class)
public class Netz_ {
	public static volatile SingularAttribute<Netz, Integer> netzId;
	public static volatile SingularAttribute<Netz, String> breitengrad;
	public static volatile SingularAttribute<Netz, String> laengengrad;
	public static volatile SingularAttribute<Netz, String> nameDesMelders;
	public static volatile SingularAttribute<Netz, String> vornameDesMelders;
	public static volatile SingularAttribute<Netz, String> groeße;
	public static volatile SingularAttribute<Netz, String> telefonnummer;
	public static volatile SingularAttribute<Netz, String> status;
	public static volatile SingularAttribute<Netz, Mitglied> mitgliedId;
}
