import java.io.File;
import java.util.Iterator;

import javax.xml.soap.Node;

import org.openstreetmap.osm.data.MemoryDataSet;
import org.openstreetmap.osm.data.coordinates.Bounds;
import org.openstreetmap.osm.io.FileLoader;
import org.openstreetmap.osmosis.core.domain.v0_6.Way;


public class OSMTraker {

	final static String VERS_STRING = "0.0.1";
	
	public static void main(String[] args) {
		System.out.println("OSM Tracer v"+VERS_STRING);
		FileLoader fl = new FileLoader(new File("data/map.osm"));
		MemoryDataSet map = fl.parseOsm();
		System.out.println("Numer of nodes      : "+map.getNodesCount());
		System.out.println("Number of ways      : "+map.getWaysCount());
		System.out.println("Number of relations : "+map.getRelationsCount());
		Iterator<Way> l = map.getWays(Bounds.WORLD);
		while (l.hasNext()) {
			Way w = l.next();
			System.out.println("Id "+w.getId()+", Ver "+w.getVersion());
		}
	}

}
