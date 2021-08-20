import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cube
import eu.mihosoft.vrl.v3d.Cylinder

//Your code here
CSG myCylinder = new Cylinder(30.56/2.0, // Radius at the bottom
                      		28.71/2.0, // Radius at the top
                      		44, // Height
                      		(int)30 //resolution
                      		).toCSG()//convert to CSG to display  
CSG core =new Cylinder(25.6/2.0,44).toCSG() // a one line Cylinder

CSG rib =new Cylinder(28.71/2.0,1).toCSG()
			.difference(
				new Cylinder(24.6/2.0,1).toCSG()) // a one line Cylinder
			.movez(myCylinder.getMaxZ()-13.3)

CSG spacing = new Cube(2,30.56,44).toCSG()
				.toZMin()

def corebit=myCylinder
			.difference(core)				
			.union(rib)
			.difference(spacing)


return [corebit]