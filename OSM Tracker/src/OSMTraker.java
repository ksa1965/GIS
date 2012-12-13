import java.io.File;
import java.util.Iterator;

import org.openstreetmap.osm.data.MemoryDataSet;
import org.openstreetmap.osm.data.WayHelper;
import org.openstreetmap.osm.data.coordinates.Bounds;
import org.openstreetmap.osm.data.coordinates.LatLon;
import org.openstreetmap.osm.io.FileLoader;
import org.openstreetmap.osmosis.core.domain.v0_6.Way;


public class OSMTraker {

	final static String VERS_STRING = "0.0.1";

	MemoryDataSet map;
	
	public OSMTraker() {
		FileLoader fl = new FileLoader(new File("data/map.osm"));
		map = fl.parseOsm();
	}
	
	
	public static void main(String[] args) {
		System.out.println("OSM Tracer v"+VERS_STRING);
		OSMTraker app = new OSMTraker();
		app.showMapInfo();
	}


	private void showMapInfo() {
		System.out.println("Numer of nodes      : "+map.getNodesCount());
		System.out.println("Number of ways      : "+map.getWaysCount());
		System.out.println("Number of relations : "+map.getRelationsCount());
		Iterator<Way> l = map.getWays(Bounds.WORLD);
		WayHelper wh = map.getWayHelper();
		while (l.hasNext()) {
			Way w = l.next();
			Bounds wb = wh.getWayBounds(w);
			LatLon center = wb.getCenter();
			System.out.println("Id "+w.getId()+", Ver "+w.getVersion()+", bounds: "+wb+ ", center: "+center);
		}
	}

}
