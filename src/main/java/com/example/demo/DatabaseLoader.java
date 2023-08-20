package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final ProductoRepository repositoryP;
	private final VentaRepository repositoryT;
	private final VendedorRepository repositoryV;
	private final ClienteRepository repositoryC;

	@Autowired
	public DatabaseLoader(
		ProductoRepository repositoryP,
		VentaRepository repositoryT,
		VendedorRepository repositoryV,
		ClienteRepository repositoryC
		) {
		this.repositoryP = repositoryP;
		this.repositoryT = repositoryT;
		this.repositoryV = repositoryV;
		this.repositoryC = repositoryC;
	}

	@Override
	public void run(String... strings) throws Exception {

		Producto P001 = new Producto("Impresa Laser HP", "Impresora", "Imprimir imagenes");
		Producto P002 = new Producto("Monitor HP", "Monitor", "Para mirar tus ttrabajos, videos,etc");
		Producto P003 = new Producto("Teclado Fanatic", "Teclado", "Para escribir tus trabajos");
		this.repositoryP.save(new Producto("Parlantes HP", "Parlante", "Para escuchar musica en cualquier lado"));
		this.repositoryP.save(new Producto("Microfono Lenovo","Microfono","Para conectarlo desde tu pc"));
		this.repositoryP.save(P001);
		this.repositoryP.save(P002);
		this.repositoryP.save(P003);

		
		Vendedor V001 = new Vendedor("luis Peres");
		Vendedor V002 = new Vendedor("Camila Flores");
		this.repositoryV.save(V001);
		this.repositoryV.save(V002);

		Cliente C001 = new Cliente("Maria Mendoza");
		Cliente C002 = new Cliente("Juaquin Torres");
		Cliente C003 = new Cliente("Hector Espinoza");
		this.repositoryC.save(C001);
		this.repositoryC.save(C002);
		this.repositoryC.save(C003);

		Venta VT001 = new Venta(P001,V002,C003);
		Venta VT002 = new Venta(P003,V001,C001);
		Venta VT003 = new Venta(P002,V001,C002);
		this.repositoryT.save(VT001);
		this.repositoryT.save(VT002);
		this.repositoryT.save(VT003);

	}
}