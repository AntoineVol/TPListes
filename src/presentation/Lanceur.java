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
		SortedMap<Object, Personne> sm = new TreeMap<Object, Personne>();
		sm.put("id1", new Personne(1, "Bruce", "Willis"));
		sm.put("id2",new Personne(2, "Chuck", "Norris"));
		sm.put("id3",new Personne(3, "Tom", "Cruise"));
		sm.put("id4",new Personne(4, "Bruce", "Wayne"));
		sm.put("id5",new Personne(5, "Tom", "Wayne"));
		
		System.out.println("------------------------ Boucle EntrySet TreeMap------------------------");		
		for(Map.Entry<Object, Personne> p :sm.entrySet()) {
			System.out.println(p.getKey() + "\t" + p.getValue().getNom() + "\t" + p.getValue().getPrenom()+ "\t" + p.getValue().getId());
		}
	
		
	}

}
