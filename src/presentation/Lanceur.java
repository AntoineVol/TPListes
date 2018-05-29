package presentation;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import domaine.Empl;
import domaine.MySalaryComp;
import domaine.Personne;

public class Lanceur {

	public static void main(String[] args) {
		//List (Vector, ArrayList, LinkedList,....)
		List vect = new Vector();
		vect.add("toto");
		vect.add(12.5);
		vect.add("toto");
		System.out.println("------------------------Boucle Liste------------------------");
		for(int i=0;i<vect.size();i++) {
			System.out.println("Index :" + i + " Donnée : " + vect.get(i));
		}
		
		
		//HashSet
		System.out.println("------------------------ Boucle for each Set------------------------");
		Set hash =new HashSet();
		hash.add(8);
		hash.add("toto");
		hash.add(12.5);
		hash.add("toto");
		hash.add(8);
	
		int j=0;
		for(Object h:hash) {
			System.out.println("Index :" + j + " Donnée :"+h);
			j++;
		}
		System.out.println("------------------------ Boucle Iterator Set------------------------");		
		Iterator it = hash.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//TreeSet
		SortedSet<Personne> set = new TreeSet<Personne>(new Comparator<Personne>() {

			@Override//la méthode est essentielle pour définir le type de tri souhaité
			public int compare(Personne p1, Personne p2) {
				if (p1.getNom().equals(p2.getNom())) {
					return -p1.getPrenom().compareTo(p2.getPrenom()); // Le - inverse l'ordre de tri
				}
				return p1.getNom().toUpperCase().compareTo(p2.getNom().toUpperCase()); //Le UpperCase permet de comparer les données en majuscule
			}
			
		});
		set.add(new Personne(1, "Bruce", "Willis"));
		set.add(new Personne(2, "Chuck", "Norris"));
		set.add(new Personne(3, "Tom", "Cruise"));
		set.add(new Personne(4, "Bruce", "Wayne"));
		set.add(new Personne(5, "Tom", "Wayne"));
		
		System.out.println("------------------------ Boucle Iterator TreeSet------------------------");		
		for(Personne p : set) {
			System.out.println(p.toString());
		}
		
		//HashTable
		Map <Object, Object> ht = new Hashtable();
		ht.put(1, "printemps");
		ht.put(2, "été");
		ht.put(3, "automne");
		ht.put("test", "hiver");
		
		// boucle la plus simple
		for(Object obj : ht.entrySet()) {
			System.out.println(obj);
			
		}
		System.out.println("------------------------ Boucle EntrySet TreeSet------------------------");		
		//boucle permettant d'extraire séparément la clé et la valeur
		// IMPORTANT Pour marcher, la déclaration de la Map doit obligatoirement préciser les types (ici <Object, Object>)
		for(Map.Entry<Object, Object> obj : ht.entrySet()) {
			System.out.print(obj.getKey() +"\t") ;
			System.out.println(obj.getValue());
			
		}
		
		
		//TreeMap
		/* This is how to declare TreeMap */
		System.out.println(
				"-------------------------------EXEMPLE 1 COMPARATEUR NATUREL ENTIER-------------------------------");
		SortedMap<Integer, String> tmap = new TreeMap<Integer, String>();

		/* Adding elements to TreeMap */
		tmap.put(1, "Data1");
		tmap.put(23, "Data2");
		tmap.put(70, "Data3");
		tmap.put(4, "Data4");
		tmap.put(2, "Data5");

		/* Display content using Iterator - Utilise l'ordre des keys */
		Set set2 = tmap.entrySet();
		Iterator iterator = set2.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print("clé: " + mentry.getKey() + " & Valeur: ");
			System.out.println(mentry.getValue());
		}

		System.out.println(
				"-------------------------------EXEMPLE 2 COMPARATEUR NATUREL STRING-------------------------------");
		// Create a hash map
		SortedMap tm = new TreeMap();

		// Put elements to the map
		tm.put("Zara", 3434.34);
		tm.put("Mahnaz", 123.22);
		tm.put("Ayan", 1378.00);
		tm.put("Daisy", 99.22);
		tm.put("Qadir", -19.08);

		// Get a set of the entries
		Set tset = tm.entrySet();

		// Get an iterator
		Iterator i = tset.iterator();

		// Display elements
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println();

		// Deposit 1000 into Zara's account
		double balance = ((Double) tm.get("Zara")).doubleValue();
		tm.put("Zara", balance + 1000);
		System.out.println("Zara's new balance: " + tm.get("Zara"));

		System.out.println("-------------------------------EXEMPLE 3 COMPARATEUR CREE-------------------------------");
		// By using name comparator (String comparison)
		SortedMap<Empl, String> tm2 = new TreeMap<Empl, String>(new Comparator<Empl>() {
			@Override
			public int compare(Empl e1, Empl e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});
		tm2.put(new Empl("Ram", 3000), "RAM");
		tm2.put(new Empl("John", 6000), "JOHN");
		tm2.put(new Empl("Crish", 2000), "CRISH");
		tm2.put(new Empl("Tom", 2400), "TOM");
		Set<Empl> keys = tm2.keySet();
		for (Empl key : keys) {
			System.out.println(key + " ==> " + tm2.get(key));
		}
		System.out.println("===================================");
		// By using salary comparator (int comparison)
		SortedMap<Empl, String> trmap = new TreeMap<Empl, String>(new MySalaryComp());
		trmap.put(new Empl("Ram", 3000), "RAM");
		trmap.put(new Empl("John", 6000), "JOHN");
		trmap.put(new Empl("Crish", 2000), "CRISH");
		trmap.put(new Empl("Tom", 2400), "TOM");
		Set<Empl> ks = trmap.keySet();
		for (Empl key : ks) {
			System.out.println(key + " ==> " + trmap.get(key));
		}
	}

	
		
}


