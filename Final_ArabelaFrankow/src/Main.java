import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		String[] dificultades = {
				"Fácil", "Medio", "Difícil"
		};
		String dificultad;
		dificultad = (String)JOptionPane.showInputDialog(null,"Elegí la dificultad del juego", "Dificultad", 0, null, dificultades, dificultades[0]);
		switch (dificultad) {
		case "Fácil":
			facil(args);
			break;
			
		case "Medio":
			medio(args);
			break;

		case "Difícil":
			dificil(args);
			break;

		default:
			break;
		}
	}
	
	//DIFICULTADES
	public static void facil(String[] args) {
		String[] accionesDia= {
				"Ir a buscar materiales", "Ir a explorar", "No hacer nada", "Inventario", "Requisitos de la casa"
		};
		String[] accionesNoche= {
				"Ir a buscar materiales", "Ir a explorar", "No hacer nada", "Inventario", "Requisitos de la casa", "Fabricar"
		};
		String[] materiales = {
				"Madera", "Piedra"
		};
		String[] fabricacion = {
				"Pico", "Hacha"
		};
		String accion, fabrica,material, nombre="";
		int madera=0,piedra=0,hierro=0, diamante=0,  contDia=0, contNoche=0;
		boolean juegoTerminado = false;
		boolean pico = false;
		boolean hacha = false;
		JOptionPane.showMessageDialog(null, "El objetivo del juego es construir la casa, al finalizar la noche se verá si pudiste conseguir el objetivo del juego");
		JOptionPane.showMessageDialog(null, "Tenés 10 acciones durante el día y 8 durante la noche");
		JOptionPane.showMessageDialog(null, "No podés morir");
		nombre = JOptionPane.showInputDialog("Ingrese su nombre");
		while (nombre.isEmpty()) {
			nombre = JOptionPane.showInputDialog("Ingrese su nombre");
		}
		//Acciones de dia
		do {
			contDia++;
			JOptionPane.showMessageDialog(null, "Día "+contDia);
			for (int j = 1; j < 11; j++) {			
			accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+j+", ¿Qué queres hacer?", "Acción del día",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/sol.jpg")), accionesDia, accionesDia[0]);
				
				switch (accion) {
				case "Ir a buscar materiales":
					material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
					if (material.equals("Madera")) {
						madera=(int)(Math.random()*100)+madera;
						JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
					} else if(material.equals("Piedra")) {
						piedra=(int)(Math.random()*100)+piedra;
						JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
					}
					break;
					
				case "Ir a explorar":
						JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
						hierro=(int)(Math.random()*20)+hierro;
						diamante=(int)(Math.random()*10)+diamante;
						JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
						JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));	
					
					break;
				case "No hacer nada":
					JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
					break;
					
				case "Inventario":
					JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
					break;
					
				case "Requisitos de la casa":
					int pregunta = JOptionPane.showConfirmDialog(null, "Necesitas 400 de madera, 300 de piedra, 25 de hierro y 10 diamantes, ¿queres ver cuántos materiales te faltan?");
					if (pregunta==0) {
						int verMadera = 400 - madera;
						int verPiedra = 300 - piedra;
						int verHierro = 25 - hierro;
						int verDiamante = 10 - diamante;
						JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
					} else {
						j = j-1;
					}
					break;
				
				default:
					break;
				}
				};
		
		
		//Acciones de noche
		
			JOptionPane.showMessageDialog(null, "No podés morir");
			JOptionPane.showMessageDialog(null, "Tenés la opción de fabricar, lo que fabriques solamente funcionará durante la noche");
			contNoche++;
			JOptionPane.showMessageDialog(null, "Noche "+contNoche);
			for (int i1 = 1; i1 < 9; i1++) {
				if (pico==true) {
					if (hacha==true) {
						JOptionPane.showMessageDialog(null, "Como tenés el pico y el hacha, vas a conseguir más recursos de todos lados");
						accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+i1+", ¿Qué queres hacer?", "Acción de noche",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/noche.jpg")), accionesNoche, accionesNoche[0]);
						switch (accion) {
						case "Ir a buscar materiales":
							material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
							if (material.equals("Madera")) {
								madera=(int)(Math.random()*200)+madera;
								JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
							} else if(material.equals("Piedra")) {
								piedra=(int)(Math.random()*200)+piedra;
								JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
							}
							break;
							
						case "Ir a explorar":
								JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
								hierro=(int)(Math.random()*40)+hierro;
								diamante=(int)(Math.random()*20)+diamante;
								JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
								JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));	
							
							break;
						case "No hacer nada":
							JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
							break;
							
						case "Inventario":
							JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
							break;
							
						case "Fabricar":
							fabrica = (String)JOptionPane.showInputDialog(null, "Qué queres fabricar?", "Fabricacion",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/mesaCraf.png")), fabricacion, fabricacion[0]);
							if (fabrica.equals("Pico")) {
								if (pico==true) {
									JOptionPane.showMessageDialog(null, "Ya tenés un pico");
								} else {
									int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 30 de madera y 30 de piedra, ¿Querés gastarlos en esto?");
									if (pregunta1==0) {
										madera = madera - 30;
										piedra = piedra - 30;
										if (madera<0 || piedra<0) {
											madera = madera + 30;
											piedra = piedra + 30;
											JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
											i1 = i1-1;
										} else {
											pico=true;
											JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu pico, ahora vas a poder conseguir el doble de materiales de la cueva y piedra");
										}
									} else {
										i1 = i1-1;
									}
								}
							} else if(fabrica.equals("Hacha")) {
								if (hacha==true) {
									JOptionPane.showMessageDialog(null, "Ya tenés un hacha");
								} else {
									int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 30 de madera y 30 de piedra, ¿Queres gastarlos en esto?");
									if (pregunta1==0) {
										madera = madera - 30;
										piedra = piedra - 30;
										if (madera<0 || piedra<0) {
											madera = madera + 30;
											piedra = piedra + 30;
											JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
											i1 = i1-1;
										} else {
											hacha=true;
											JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu hacha, ahora vas a poder conseguir el doble de madera");
										}
									} else {
										i1 = i1-1;
									}
								}
							}
							
							break;
							
						case "Requisitos de la casa":
							int pregunta = JOptionPane.showConfirmDialog(null, "Necesitas 400 de madera, 300 de piedra, 25 de hierro y 10 diamantes, ¿queres ver cuántos materiales te faltan?");
							if (pregunta==0) {
								int verMadera = 400 - madera;
								int verPiedra = 300 - piedra;
								int verHierro = 25 - hierro;
								int verDiamante = 10 - diamante;
								JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
							} else {
								i1 = i1-1;
							}
							break;
						
						default:
							break;
						}
							if (juegoTerminado==true) {
								break;
							}
					}else {
						JOptionPane.showMessageDialog(null, "Como solamente tenés el pico, solo vas a conseguir más recursos en las cuevas y juntando piedra");
						accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+i1+", ¿Qué queres hacer?", "Acción de noche",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/noche.jpg")), accionesNoche, accionesNoche[0]);
						switch (accion) {
						case "Ir a buscar materiales":
							material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
							if (material.equals("Madera")) {
								madera=(int)(Math.random()*100)+madera;
								JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
							} else if(material.equals("Piedra")) {
								piedra=(int)(Math.random()*200)+piedra;
								JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
							}
							break;
							
						case "Ir a explorar":
								JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
								hierro=(int)(Math.random()*40)+hierro;
								diamante=(int)(Math.random()*20)+diamante;
								JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
								JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));	
							
							break;
						case "No hacer nada":
							JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
							break;
							
						case "Inventario":
							JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
							break;
							
						case "Fabricar":
							fabrica = (String)JOptionPane.showInputDialog(null, "Qué queres fabricar?", "Fabricacion",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/mesaCraf.png")), fabricacion, fabricacion[0]);
							if (fabrica.equals("Pico")) {
								if (pico==true) {
									JOptionPane.showMessageDialog(null, "Ya tenés un pico");
								} else {
									int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 30 de madera y 30 de piedra, ¿Queres gastarlos en esto?");
									if (pregunta1==0) {
										madera = madera - 30;
										piedra = piedra - 30;
										if (madera<0 || piedra<0) {
											madera = madera + 30;
											piedra = piedra + 30;
											JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
											i1 = i1-1;
										} else {
											pico=true;
											JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu pico, ahora vas a poder conseguir el doble de materiales de la cueva y piedra");
										}
									} else {
										i1 = i1-1;
									}
								}
							} else if(fabrica.equals("Hacha")) {
								if (hacha==true) {
									JOptionPane.showMessageDialog(null, "Ya tenés un hacha");
								} else {
									int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 30 de madera y 30 de piedra, ¿Queres gastarlos en esto?");
									if (pregunta1==0) {
										madera = madera - 30;
										piedra = piedra - 30;
										if (madera<0 || piedra<0) {
											madera = madera + 30;
											piedra = piedra + 30;
											JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
											i1 = i1-1;
										} else {
											hacha=true;
											JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu hacha, ahora vas a poder conseguir el doble de madera");
										}
									} else {
										i1 = i1-1;
									}
								}
							}
							
							break;
							
						case "Requisitos de la casa":
							int pregunta = JOptionPane.showConfirmDialog(null, "Necesitas 400 de madera, 300 de piedra, 25 de hierro y 10 diamantes, ¿Queres ver cuántos materiales te faltan?");
							if (pregunta==0) {
								int verMadera = 400 - madera;
								int verPiedra = 300 - piedra;
								int verHierro = 25 - hierro;
								int verDiamante = 10 - diamante;
								JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
							} else {
								i1 = i1-1;
							}
							break;
						
						default:
							break;
						}
							if (juegoTerminado==true) {
								break;
							}
					}
				} else if(hacha==true){
					JOptionPane.showMessageDialog(null, "Como solo tenés el hacha, vas a conseguir el doble de recompensa en la madera solamente");
					accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+i1+", ¿Qué querés hacer?", "Acción de noche",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/noche.jpg")), accionesNoche, accionesNoche[0]);
					switch (accion) {
					case "Ir a buscar materiales":
						material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
						if (material.equals("Madera")) {
							madera=(int)(Math.random()*200)+madera;
							JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
						} else if(material.equals("Piedra")) {
							piedra=(int)(Math.random()*100)+piedra;
							JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
						}
						break;
						
					case "Ir a explorar":
							JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
							hierro=(int)(Math.random()*20)+hierro;
							diamante=(int)(Math.random()*10)+diamante;
							JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
							JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));	
						
						break;
					case "No hacer nada":
						JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
						break;
						
					case "Inventario":
						JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
						break;
						
					case "Fabricar":
						fabrica = (String)JOptionPane.showInputDialog(null, "Qué queres fabricar?", "Fabricacion",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/mesaCraf.png")), fabricacion, fabricacion[0]);
						if (fabrica.equals("Pico")) {
							if (pico==true) {
								JOptionPane.showMessageDialog(null, "Ya tenés un pico");
							} else {
								int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 30 de madera y 30 de piedra, ¿Queres gastarlos en esto?");
								if (pregunta1==0) {
									madera = madera - 30;
									piedra = piedra - 30;
									if (madera<0 || piedra<0) {
										madera = madera + 30;
										piedra = piedra + 30;
										JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
										i1 = i1-1;
									} else {
										pico=true;
										JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu pico, ahora vas a poder conseguir el doble de materiales de la cueva y piedra");
									}
								} else {
									i1 = i1-1;
								}
							}
						} else if(fabrica.equals("Hacha")) {
							if (hacha==true) {
								JOptionPane.showMessageDialog(null, "Ya tenés un hacha");
							} else {
								int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 30 de madera y 30 de piedra, ¿Queres gastarlos en esto?");
								if (pregunta1==0) {
									madera = madera - 30;
									piedra = piedra - 30;
									if (madera<0 || piedra<0) {
										madera = madera + 30;
										piedra = piedra + 30;
										JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
										i1 = i1-1;
									} else {
										hacha=true;
										JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu hacha, ahora vas a poder conseguir el doble de madera");
									}
								} else {
									i1 = i1-1;
								}
							}
						}
						
						break;
						
					case "Requisitos de la casa":
						int pregunta = JOptionPane.showConfirmDialog(null, "Necesitas 400 de madera, 300 de piedra, 25 de hierro y 10 diamantes, ¿Queres ver cuántos materiales te faltan?");
						if (pregunta==0) {
							int verMadera = 400 - madera;
							int verPiedra = 300 - piedra;
							int verHierro = 25 - hierro;
							int verDiamante = 10 - diamante;
							JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
						} else {
							i1 = i1-1;
						}
						break;
					
					default:
						break;
					}
						if (juegoTerminado==true) {
							break;
						}
				} else {
					JOptionPane.showMessageDialog(null, "Como no tenés objetos fabricados, no vas a conseguir materiales extra");
					accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+i1+", ¿Qué querés hacer?", "Acción de noche",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/noche.jpg")), accionesNoche, accionesNoche[0]);
					switch (accion) {
					case "Ir a buscar materiales":
						material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
						if (material.equals("Madera")) {
							madera=(int)(Math.random()*100)+madera;
							JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
						} else if(material.equals("Piedra")) {
							piedra=(int)(Math.random()*100)+piedra;
							JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
						}
						break;
						
					case "Ir a explorar":
							JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
							hierro=(int)(Math.random()*20)+hierro;
							diamante=(int)(Math.random()*10)+diamante;
							JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
							JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));	
						
						break;
					case "No hacer nada":
						JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
						break;
						
					case "Inventario":
						JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
						break;
						
					case "Fabricar":
						fabrica = (String)JOptionPane.showInputDialog(null, "Qué queres fabricar?", "Fabricacion",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/mesaCraf.png")), fabricacion, fabricacion[0]);
						if (fabrica.equals("Pico")) {
							if (pico==true) {
								JOptionPane.showMessageDialog(null, "Ya tenés un pico");
							} else {
								int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 30 de madera y 30 de piedra, ¿Queres gastarlos en esto?");
								if (pregunta1==0) {
									madera = madera - 30;
									piedra = piedra - 30;
									if (madera<0 || piedra<0) {
										madera = madera + 30;
										piedra = piedra + 30;
										JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
										i1 = i1-1;
									} else {
										pico=true;
										JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu pico, ahora vas a poder conseguir el doble de materiales de la cueva y piedra");
									}
								} else {
									i1 = i1-1;
								}
							}
						} else if(fabrica.equals("Hacha")) {
							if (hacha==true) {
								JOptionPane.showMessageDialog(null, "Ya tenés un hacha");
							} else {
								int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 30 de madera y 30 de piedra, ¿Queres gastarlos en esto?");
								if (pregunta1==0) {
									madera = madera - 30;
									piedra = piedra - 30;
									if (madera<0 || piedra<0) {
										madera = madera + 30;
										piedra = piedra + 30;
										JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
										i1 = i1-1;
									} else {
										hacha=true;
										JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu hacha, ahora vas a poder conseguir el doble de madera");
									}
								} else {
									i1 = i1-1;
								}
							}
						}
						
						break;
						
					case "Requisitos de la casa":
						int pregunta = JOptionPane.showConfirmDialog(null, "Necesitas 400 de madera, 300 de piedra, 25 de hierro y 10 diamantes, ¿Queres ver cuántos materiales te faltan?");
						if (pregunta==0) {
							int verMadera = 400 - madera;
							int verPiedra = 300 - piedra;
							int verHierro = 25 - hierro;
							int verDiamante = 10 - diamante;
							JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
						} else {
							i1 = i1-1;
						}
						break;
					
					default:
						break;
					}
						if (juegoTerminado==true) {
							break;
						}
				}
				
			}
			if (madera>=400 && piedra>=300 && hierro>=25 && diamante>=10) {
				JOptionPane.showMessageDialog(null, "Conseguiste armar tu casa!! Felicidades", "Ganaste!!", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/casa.jpg")));
				juegoTerminado=true;
			};
		}while (juegoTerminado==false);
		JOptionPane.showMessageDialog(null, "Nombre: "+nombre+"\n"+"Estuviste con vida: "+contDia+" dias"+"\n"+"Madera obtenida: "+madera+"\n Piedra obtenida: "+piedra+"\n Hierro obtenido: "+hierro+"\n Diamante obtenido: "+diamante+"\n"+"Conseguiste fabricar el hacha: "+hacha+"\n"+"Conseguiste fabricar el pico: "+pico);
	}

	
	public static void medio(String[] args) {
		String[] accionesDia= {
				"Ir a buscar materiales", "Ir a explorar", "No hacer nada", "Inventario", "Requisitos de la casa"
		};
		String[] accionesNoche= {
				"Ir a buscar materiales", "Ir a explorar", "No hacer nada", "Inventario", "Requisitos de la casa", "Fabricar"
		};
		String[] materiales = {
				"Madera", "Piedra"
		};
		String[] fabricacion = {
				"Pico", "Hacha"
		};
		String accion, fabrica,material, nombre="";
		int madera=0,piedra=0,hierro=0, diamante=0,  contDia=0, contNoche=0, porcentajeNoche=0;
		boolean juegoTerminado = false;
		boolean pico = false;
		boolean hacha = false;
		JOptionPane.showMessageDialog(null, "El objetivo del juego es construir la casa, al finalizar la noche se verá si pudiste hacer tu casa, si morís perdés el juego");
		JOptionPane.showMessageDialog(null, "Tenés 10 acciones durante el día y 8 durante la noche");
		nombre = JOptionPane.showInputDialog("Ingrese su nombre");
		while (nombre.isEmpty()) {
			nombre = JOptionPane.showInputDialog("Ingrese su nombre");
		}
		//Acciones de día
		do {
			contDia++;
			JOptionPane.showMessageDialog(null, "Día "+contDia);
			for (int j = 1; j < 11; j++) {			
			accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+j+", ¿Qué queres hacer?", "Acción del día",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/sol.jpg")), accionesDia, accionesDia[0]);
				
				switch (accion) {
				case "Ir a buscar materiales":
					material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
					if (material.equals("Madera")) {
						madera=(int)(Math.random()*100)+madera;
						JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
					} else if(material.equals("Piedra")) {
						piedra=(int)(Math.random()*100)+piedra;
						JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
					}
					break;
					
				case "Ir a explorar":
						JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
						hierro=(int)(Math.random()*20)+hierro;
						diamante=(int)(Math.random()*10)+diamante;
						JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
						JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));	
					
					break;
				case "No hacer nada":
					JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
					break;
					
				case "Inventario":
					JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
					break;
					
				case "Requisitos de la casa":
					int pregunta = JOptionPane.showConfirmDialog(null, "Necesitas 1000 de madera, 750 de piedra, 50 de hierro y 25 diamantes, ¿Queres ver cuántos materiales te faltan?");
					if (pregunta==0) {
						int verMadera = 1000 - madera;
						int verPiedra = 750 - piedra;
						int verHierro = 50 - hierro;
						int verDiamante = 25 - diamante;
						JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
					} else {
						j = j-1;
					}
					break;
				
				default:
					break;
				}
				};
		
		
		//Acciones de noche
		
			JOptionPane.showMessageDialog(null, "Tenés un 30% de morir en todas las acciones menos en la acción de no hacer nada");
			JOptionPane.showMessageDialog(null, "Tenés la opción de fabricar, lo que fabriques solamente funcionará durante la noche");
			contNoche++;
			JOptionPane.showMessageDialog(null, "Noche "+contNoche);
			for (int i1 = 1; i1 < 9; i1++) {					
				if (pico==true) {
					if (hacha==true) {
						JOptionPane.showMessageDialog(null, "Como tenés el pico y el hacha, vas a conseguir mas recursos de todos lados");
						accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+i1+", ¿Qué querés hacer?", "Acción de noche",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/noche.jpg")), accionesNoche, accionesNoche[0]);
						switch (accion) {
						case "Ir a buscar materiales":
							material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
							if (material.equals("Madera")) {
								porcentajeNoche = (int)(Math.random()*10);
								if (porcentajeNoche>=0 && porcentajeNoche<=2 ) {
									JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
									juegoTerminado = true;
								}else {
									madera=(int)(Math.random()*200)+madera;
									JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
								}
								
							} else if(material.equals("Piedra")) {
								porcentajeNoche = (int)(Math.random()*10);
								if (porcentajeNoche>=0 && porcentajeNoche<=2 ) {
									JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
									juegoTerminado = true;
								}else {
									piedra=(int)(Math.random()*200)+piedra;
									JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
								}
								
							}
							break;
							
						case "Ir a explorar":
							int pregunta= JOptionPane.showConfirmDialog(null, "Tenés un 50% de probabilidad de morir, ¿Querés explorar igual?");
							if (pregunta==0) {
								JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
								porcentajeNoche= (int)(Math.random()*10);
								if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
									JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
									juegoTerminado = true;
								} else {
									hierro=(int)(Math.random()*40)+hierro;
									diamante=(int)(Math.random()*20)+diamante;
									JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
									JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));
								}
							} else {
								i1 = i1-1;
							}
							
							break;
						case "No hacer nada":
							JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
							break;
							
						case "Inventario":
							JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
							break;
							
						case "Fabricar":
							fabrica = (String)JOptionPane.showInputDialog(null, "Qué queres fabricar?", "Fabricacion",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/mesaCraf.png")), fabricacion, fabricacion[0]);
							if (fabrica.equals("Pico")) {
								if (pico==true) {
									JOptionPane.showMessageDialog(null, "Ya tenés un pico");
								} else {
									int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 60 de madera y 60 de piedra, ¿Queres gastarlos en esto?");
									if (pregunta1==0) {
										madera = madera - 60;
										piedra = piedra - 60;
										if (madera<0 || piedra<0) {
											madera = madera + 60;
											piedra = piedra + 60;
											JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
											i1 = i1-1;
										} else {
											pico=true;
											JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu pico, ahora vas a poder conseguir el doble de materiales de la cueva y piedra");
										}
									} else {
										i1 = i1-1;
									}
								}
							} else if(fabrica.equals("Hacha")) {
								if (hacha==true) {
									JOptionPane.showMessageDialog(null, "Ya tenés un hacha");
								} else {
									int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 60 de madera y 60 de piedra, ¿Querés gastarlos en esto?");
									if (pregunta1==0) {
										madera = madera - 60;
										piedra = piedra - 60;
										if (madera<0 || piedra<0) {
											madera = madera + 60;
											piedra = piedra + 60;
											JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
											i1 = i1-1;
										} else {
											hacha=true;
											JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu hacha, ahora vas a poder conseguir el doble de madera");
										}
									} else {
										i1 = i1-1;
									}
								}
							}
							
							break;
							
						case "Requisitos de la casa":
							int pregunta2 = JOptionPane.showConfirmDialog(null, "Necesitas 1000 de madera, 750 de piedra, 50 de hierro y 25 diamantes, ¿Queres ver cuántos materiales te faltan?");
							if (pregunta2==0) {
								int verMadera = 1000 - madera;
								int verPiedra = 750 - piedra;
								int verHierro = 50 - hierro;
								int verDiamante = 25 - diamante;
								JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
							} else {
								i1 = i1-1;
							}
							break;
						
						default:
							break;
						}
							if (juegoTerminado==true) {
								break;
							}
					}else {
						JOptionPane.showMessageDialog(null, "Como solamente tenés el pico, solo vas a conseguir más recursos en las cuevas y juntando piedra");
						accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+i1+", ¿Qué queres hacer?", "Acción de noche",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/noche.jpg")), accionesNoche, accionesNoche[0]);
						switch (accion) {
						case "Ir a buscar materiales":
							material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
							if (material.equals("Madera")) {
								porcentajeNoche = (int)(Math.random()*10);
								if (porcentajeNoche>=0 && porcentajeNoche<=2 ) {
									JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
									juegoTerminado = true;
								}else {
									madera=(int)(Math.random()*100)+madera;
									JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
								}
								
							} else if(material.equals("Piedra")) {
								porcentajeNoche = (int)(Math.random()*10);
								if (porcentajeNoche>=0 && porcentajeNoche<=2 ) {
									JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
									juegoTerminado = true;
								}else {
									piedra=(int)(Math.random()*200)+piedra;
									JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
								}
								
							}
							break;
							
						case "Ir a explorar":
							int pregunta= JOptionPane.showConfirmDialog(null, "Tenés un 50% de probabilidad de morir, ¿Querés explorar igual?");
							if (pregunta==0) {
								JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
								porcentajeNoche= (int)(Math.random()*10);
								if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
									JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
									juegoTerminado = true;
								} else {
									hierro=(int)(Math.random()*40)+hierro;
									diamante=(int)(Math.random()*20)+diamante;
									JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
									JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));
								}
							} else {
								i1 = i1-1;
							}
							
							break;
						case "No hacer nada":
							JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
							break;
							
						case "Inventario":
							JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
							break;
							
						case "Fabricar":
							fabrica = (String)JOptionPane.showInputDialog(null, "Qué queres fabricar?", "Fabricacion",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/mesaCraf.png")), fabricacion, fabricacion[0]);
							if (fabrica.equals("Pico")) {
								if (pico==true) {
									JOptionPane.showMessageDialog(null, "Ya tenés un pico");
								} else {
									int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 60 de madera y 60 de piedra, ¿Queres gastarlos en esto?");
									if (pregunta1==0) {
										madera = madera - 60;
										piedra = piedra - 60;
										if (madera<0 || piedra<0) {
											madera = madera + 60;
											piedra = piedra + 60;
											JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
											i1 = i1-1;
										} else {
											pico=true;
											JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu pico, ahora vas a poder conseguir el doble de materiales de la cueva y piedra");
										}
									} else {
										i1 = i1-1;
									}
								}
							} else if(fabrica.equals("Hacha")) {
								if (hacha==true) {
									JOptionPane.showMessageDialog(null, "Ya tenés un hacha");
								} else {
									int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 60 de madera y 60 de piedra, ¿Querés gastarlos en esto?");
									if (pregunta1==0) {
										madera = madera - 60;
										piedra = piedra - 60;
										if (madera<0 || piedra<0) {
											madera = madera + 60;
											piedra = piedra + 60;
											JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
											i1 = i1-1;
										} else {
											hacha=true;
											JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu hacha, ahora vas a poder conseguir el doble de madera");
										}
									} else {
										i1 = i1-1;
									}
								}
							}
							
							break;
							
						case "Requisitos de la casa":
							int pregunta2 = JOptionPane.showConfirmDialog(null, "Necesitas 1000 de madera, 750 de piedra, 50 de hierro y 25 diamantes, ¿Queres ver cuántos materiales te faltan?");
							if (pregunta2==0) {
								int verMadera = 1000 - madera;
								int verPiedra = 750 - piedra;
								int verHierro = 50 - hierro;
								int verDiamante = 25 - diamante;
								JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
							} else {
								i1 = i1-1;
							}
							break;
						
						default:
							break;
						}
							if (juegoTerminado==true) {
								break;
							}
					}
				} else if(hacha==true){
					JOptionPane.showMessageDialog(null, "Como solo tenés el hacha, vas a conseguir el doble de recompensa en la madera solamente");
					accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+i1+", ¿Qué querés hacer?", "Acción de noche",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/noche.jpg")), accionesNoche, accionesNoche[0]);
					switch (accion) {
					case "Ir a buscar materiales":
						material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
						if (material.equals("Madera")) {
							porcentajeNoche = (int)(Math.random()*10);
							if (porcentajeNoche>=0 && porcentajeNoche<=2 ) {
								JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
								juegoTerminado = true;
							}else {
								madera=(int)(Math.random()*200)+madera;
								JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
							}
							
						} else if(material.equals("Piedra")) {
							porcentajeNoche = (int)(Math.random()*10);
							if (porcentajeNoche>=0 && porcentajeNoche<=2 ) {
								JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
								juegoTerminado = true;
							}else {
								piedra=(int)(Math.random()*100)+piedra;
								JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
							}
							
						}
						break;
						
					case "Ir a explorar":
						int pregunta= JOptionPane.showConfirmDialog(null, "Tenés un 50% de probabilidad de morir, ¿Querés explorar igual?");
						if (pregunta==0) {
							JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
							porcentajeNoche= (int)(Math.random()*10);
							if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
								JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
								juegoTerminado = true;
							} else {
								hierro=(int)(Math.random()*20)+hierro;
								diamante=(int)(Math.random()*10)+diamante;
								JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
								JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));
							}
						} else {
							i1 = i1-1;
						}
						
						break;
					case "No hacer nada":
						JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
						break;
						
					case "Inventario":
						JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
						break;
						
					case "Fabricar":
						fabrica = (String)JOptionPane.showInputDialog(null, "Qué queres fabricar?", "Fabricacion",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/mesaCraf.png")), fabricacion, fabricacion[0]);
						if (fabrica.equals("Pico")) {
							if (pico==true) {
								JOptionPane.showMessageDialog(null, "Ya tenés un pico");
							} else {
								int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 60 de madera y 60 de piedra, ¿Querés gastarlos en esto?");
								if (pregunta1==0) {
									madera = madera - 60;
									piedra = piedra - 60;
									if (madera<0 || piedra<0) {
										madera = madera + 60;
										piedra = piedra + 60;
										JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
										i1 = i1-1;
									} else {
										pico=true;
										JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu pico, ahora vas a poder conseguir el doble de materiales de la cueva y piedra");
									}
								} else {
									i1 = i1-1;
								}
							}
						} else if(fabrica.equals("Hacha")) {
							if (hacha==true) {
								JOptionPane.showMessageDialog(null, "Ya tenés un hacha");
							} else {
								int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 60 de madera y 60 de piedra, ¿Querés gastarlos en esto?");
								if (pregunta1==0) {
									madera = madera - 60;
									piedra = piedra - 60;
									if (madera<0 || piedra<0) {
										madera = madera + 60;
										piedra = piedra + 60;
										JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
										i1 = i1-1;
									} else {
										hacha=true;
										JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu hacha, ahora vas a poder conseguir el doble de madera");
									}
								} else {
									i1 = i1-1;
								}
							}
						}
						
						break;
						
					case "Requisitos de la casa":
						int pregunta2 = JOptionPane.showConfirmDialog(null, "Necesitas 1000 de madera, 750 de piedra, 50 de hierro y 25 diamantes, ¿Queres ver cuántos materiales te faltan?");
						if (pregunta2==0) {
							int verMadera = 1000 - madera;
							int verPiedra = 750 - piedra;
							int verHierro = 50 - hierro;
							int verDiamante = 25 - diamante;
							JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
						} else {
							i1 = i1-1;
						}
						break;
					
					default:
						break;
					}
						if (juegoTerminado==true) {
							break;
						}
				} else {
					JOptionPane.showMessageDialog(null, "Como no tenés objetos fabricados, no vas a conseguir materiales extra");
					accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+i1+", ¿Qué querés hacer?", "Acción de noche",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/noche.jpg")), accionesNoche, accionesNoche[0]);
					switch (accion) {
					case "Ir a buscar materiales":
						material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
						if (material.equals("Madera")) {
							porcentajeNoche = (int)(Math.random()*10);
							if (porcentajeNoche>=0 && porcentajeNoche<=2 ) {
								JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
								juegoTerminado = true;
							}else {
								madera=(int)(Math.random()*100)+madera;
								JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
							}
							
						} else if(material.equals("Piedra")) {
							porcentajeNoche = (int)(Math.random()*10);
							if (porcentajeNoche>=0 && porcentajeNoche<=2 ) {
								JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
								juegoTerminado = true;
							}else {
								piedra=(int)(Math.random()*100)+piedra;
								JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
							}
							
						}
						break;
						
					case "Ir a explorar":
						int pregunta= JOptionPane.showConfirmDialog(null, "Tenés un 50% de probabilidad de morir, ¿Queres explorar igual?");
						if (pregunta==0) {
							JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
							porcentajeNoche= (int)(Math.random()*10);
							if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
								JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
								juegoTerminado = true;
							} else {
								hierro=(int)(Math.random()*20)+hierro;
								diamante=(int)(Math.random()*10)+diamante;
								JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
								JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));
							}
						} else {
							i1 = i1-1;
						}
						
						break;
					case "No hacer nada":
						JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
						break;
						
					case "Inventario":
						JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
						break;
						
					case "Fabricar":
						fabrica = (String)JOptionPane.showInputDialog(null, "Qué queres fabricar?", "Fabricacion",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/mesaCraf.png")), fabricacion, fabricacion[0]);
						if (fabrica.equals("Pico")) {
							if (pico==true) {
								JOptionPane.showMessageDialog(null, "Ya tenés un pico");
							} else {
								int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 30 de madera y 30 de piedra, ¿Queres gastarlos en esto?");
								if (pregunta1==0) {
									madera = madera - 60;
									piedra = piedra - 60;
									if (madera<0 || piedra<0) {
										madera = madera + 60;
										piedra = piedra + 60;
										JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
										i1 = i1-1;
									} else {
										pico=true;
										JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu pico, ahora vas a poder conseguir el doble de materiales de la cueva y piedra");
									}
								} else {
									i1 = i1-1;
								}
							}
						} else if(fabrica.equals("Hacha")) {
							if (hacha==true) {
								JOptionPane.showMessageDialog(null, "Ya tenés un hacha");
							} else {
								int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 30 de madera y 30 de piedra, ¿Queres gastarlos en esto?");
								if (pregunta1==0) {
									madera = madera - 60;
									piedra = piedra - 60;
									if (madera<0 || piedra<0) {
										madera = madera + 60;
										piedra = piedra + 60;
										JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
										i1 = i1-1;
									} else {
										hacha=true;
										JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu hacha, ahora vas a poder conseguir el doble de madera");
									}
								} else {
									i1 = i1-1;
								}
							}
						}
						
						break;
						
					case "Requisitos de la casa":
						int pregunta2 = JOptionPane.showConfirmDialog(null, "Necesitas 1000 de madera, 750 de piedra, 50 de hierro y 25 diamantes, ¿Queres ver cuántos materiales te faltan?");
						if (pregunta2==0) {
							int verMadera = 1000 - madera;
							int verPiedra = 750 - piedra;
							int verHierro = 50 - hierro;
							int verDiamante = 25 - diamante;
							JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
						} else {
							i1 = i1-1;
						}
						break;
					
					default:
						break;
					}
						if (juegoTerminado==true) {
							break;
						}
				}
			}
			if (madera>=1000 && piedra>=750 && hierro>=50 && diamante>=25) {
				JOptionPane.showMessageDialog(null, "Conseguiste armar tu casa!! Felicidades", "Ganaste!!", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/casa.jpg")));
				juegoTerminado=true;
			};
		}while (juegoTerminado==false);
		JOptionPane.showMessageDialog(null, "Nombre: "+nombre+"\n"+"Estuviste con vida: "+contDia+" dias"+"\n"+"Madera obtenida: "+madera+"\n Piedra obtenida: "+piedra+"\n Hierro obtenido: "+hierro+"\n Diamante obtenido: "+diamante+"\n"+"Conseguiste fabricar el hacha: "+hacha+"\n"+"Conseguiste fabricar el pico: "+pico);
	}
	
	
	public static void dificil(String[] args) {
		String[] accionesDia= {
				"Ir a buscar materiales", "Ir a explorar", "No hacer nada", "Inventario", "Requisitos de la casa"
		};
		String[] accionesNoche= {
				"Ir a buscar materiales", "Ir a explorar", "No hacer nada", "Inventario", "Requisitos de la casa", "Fabricar"
		};
		String[] materiales = {
				"Madera", "Piedra"
		};
		String[] fabricacion = {
				"Pico", "Hacha"
		};
		String accion, fabrica,material, nombre="";
		int madera=0,piedra=0,hierro=0, diamante=0,  contDia=0, contNoche=0, porcentajeNoche=0;
		boolean juegoTerminado = false;
		boolean pico = false;
		boolean hacha = false;
		JOptionPane.showMessageDialog(null, "El objetivo del juego es construir la casa, al finalizar la noche se verá si pudiste hacer tu casa, si morís perdés el juego");
		JOptionPane.showMessageDialog(null, "Tenés 10 acciones durante el día y 8 durante la noche");
		nombre = JOptionPane.showInputDialog("Ingrese su nombre");
		while (nombre.isEmpty()) {
			nombre = JOptionPane.showInputDialog("Ingrese su nombre");
		}
		//Acciones de dia
		do {
			contDia++;
			JOptionPane.showMessageDialog(null, "Día "+contDia);
			for (int j = 1; j < 11; j++) {			
			accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+j+", ¿Qué queres hacer?", "Acción del día",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/sol.jpg")), accionesDia, accionesDia[0]);
				
				switch (accion) {
				case "Ir a buscar materiales":
					material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
					if (material.equals("Madera")) {
						madera=(int)(Math.random()*100)+madera;
						JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
					} else if(material.equals("Piedra")) {
						piedra=(int)(Math.random()*100)+piedra;
						JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
					}
					break;
					
				case "Ir a explorar":
						JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
						hierro=(int)(Math.random()*20)+hierro;
						diamante=(int)(Math.random()*10)+diamante;
						JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
						JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));	
					
					break;
				case "No hacer nada":
					JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
					break;
					
				case "Inventario":
					JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
					break;
					
				case "Requisitos de la casa":
					int pregunta = JOptionPane.showConfirmDialog(null, "Necesitas 2000 de madera, 1400 de piedra, 100 de hierro y 50 diamantes, ¿Queres ver cuántos materiales te faltan?");
					if (pregunta==0) {
						int verMadera = 2000 - madera;
						int verPiedra = 1400 - piedra;
						int verHierro = 100 - hierro;
						int verDiamante = 50 - diamante;
						JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
					} else {
						j = j-1;
					}
					break;
				
				default:
					break;
				}
				};
		
		
		//Acciones de noche
		
			JOptionPane.showMessageDialog(null, "Tenés un 50% de morir en todas las acciones menos en la acción de no hacer nada");
			JOptionPane.showMessageDialog(null, "Tenés la opción de fabricar, lo que fabriques solamente funcionará durante la noche");
			contNoche++;
			JOptionPane.showMessageDialog(null, "Noche "+contNoche);
			for (int i1 = 1; i1 < 9; i1++) {					
				if (pico==true) {
					if (hacha==true) {
						JOptionPane.showMessageDialog(null, "Como tenés el pico y el hacha, vas a conseguir más recursos de todos lados");
						accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+i1+", ¿Qué querés hacer?", "Acción de noche",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/noche.jpg")), accionesNoche, accionesNoche[0]);
						switch (accion) {
						case "Ir a buscar materiales":
							material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
							if (material.equals("Madera")) {
								porcentajeNoche = (int)(Math.random()*10);
								if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
									JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
									juegoTerminado = true;
								}else {
									madera=(int)(Math.random()*150)+madera;
									JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
								}
								
							} else if(material.equals("Piedra")) {
								porcentajeNoche = (int)(Math.random()*10);
								if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
									JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
									juegoTerminado = true;
								}else {
									piedra=(int)(Math.random()*150)+piedra;
									JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
								}
								
							}
							break;
							
						case "Ir a explorar":
								JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
								porcentajeNoche= (int)(Math.random()*10);
								if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
									JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
									juegoTerminado = true;
								} else {
									hierro=(int)(Math.random()*30)+hierro;
									diamante=(int)(Math.random()*10)+diamante;
									JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
									JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));
								}
							
							break;
						case "No hacer nada":
							JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
							break;
							
						case "Inventario":
							JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
							break;
							
						case "Fabricar":
							fabrica = (String)JOptionPane.showInputDialog(null, "Qué queres fabricar?", "Fabricacion",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/mesaCraf.png")), fabricacion, fabricacion[0]);
							if (fabrica.equals("Pico")) {
								if (pico==true) {
									JOptionPane.showMessageDialog(null, "Ya tenés un pico");
								} else {
									int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 80 de madera y 80 de piedra, ¿Queres gastarlos en esto?");
									if (pregunta1==0) {
										madera = madera - 80;
										piedra = piedra - 80;
										if (madera<0 || piedra<0) {
											madera = madera + 80;
											piedra = piedra + 80;
											JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
											i1 = i1-1;
										} else {
											pico=true;
											JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu pico, ahora vas a poder conseguir el doble de materiales de la cueva y piedra");
										}
									} else {
										i1 = i1-1;
									}
								}
							} else if(fabrica.equals("Hacha")) {
								if (hacha==true) {
									JOptionPane.showMessageDialog(null, "Ya tenés un hacha");
								} else {
									int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 80 de madera y 80 de piedra, ¿Queres gastarlos en esto?");
									if (pregunta1==0) {
										madera = madera - 80;
										piedra = piedra - 80;
										if (madera<0 || piedra<0) {
											madera = madera + 80;
											piedra = piedra + 80;
											JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
											i1 = i1-1;
										} else {
											hacha=true;
											JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu hacha, ahora vas a poder conseguir el doble de madera");
										}
									} else {
										i1 = i1-1;
									}
								}
							}
							
							break;
							
						case "Requisitos de la casa":
							int pregunta2 = JOptionPane.showConfirmDialog(null, "Necesitas 2000 de madera, 1400 de piedra, 100 de hierro y 50 diamantes, ¿Queres ver cuántos materiales te faltan?");
							if (pregunta2==0) {
								int verMadera = 2000 - madera;
								int verPiedra = 1400 - piedra;
								int verHierro = 100 - hierro;
								int verDiamante = 50 - diamante;
								JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
							} else {
								i1 = i1-1;
							}
							break;
						
						default:
							break;
						}
							if (juegoTerminado==true) {
								break;
							}
					}else {
						JOptionPane.showMessageDialog(null, "Como solamente tenés el pico, solo vas a conseguir mas recursos en las cuevas y juntando piedra");
						accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+i1+", ¿Qué querés hacer?", "Acción de noche",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/noche.jpg")), accionesNoche, accionesNoche[0]);
						switch (accion) {
						case "Ir a buscar materiales":
							material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
							if (material.equals("Madera")) {
								porcentajeNoche = (int)(Math.random()*10);
								if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
									JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
									juegoTerminado = true;
								}else {
									madera=(int)(Math.random()*75)+madera;
									JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
								}
								
							} else if(material.equals("Piedra")) {
								porcentajeNoche = (int)(Math.random()*10);
								if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
									JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
									juegoTerminado = true;
								}else {
									piedra=(int)(Math.random()*150)+piedra;
									JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
								}
								
							}
							break;
							
						case "Ir a explorar":
								JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
								porcentajeNoche= (int)(Math.random()*10);
								if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
									JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
									juegoTerminado = true;
								} else {
									hierro=(int)(Math.random()*30)+hierro;
									diamante=(int)(Math.random()*10)+diamante;
									JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
									JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));
								}
							
							
							break;
						case "No hacer nada":
							JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
							break;
							
						case "Inventario":
							JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
							break;
							
						case "Fabricar":
							fabrica = (String)JOptionPane.showInputDialog(null, "Qué queres fabricar?", "Fabricacion",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/mesaCraf.png")), fabricacion, fabricacion[0]);
							if (fabrica.equals("Pico")) {
								if (pico==true) {
									JOptionPane.showMessageDialog(null, "Ya tenés un pico");
								} else {
									int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 80 de madera y 80 de piedra, ¿Queres gastarlos en esto?");
									if (pregunta1==0) {
										madera = madera - 80;
										piedra = piedra - 80;
										if (madera<0 || piedra<0) {
											madera = madera + 80;
											piedra = piedra + 80;
											JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
											i1 = i1-1;
										} else {
											pico=true;
											JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu pico, ahora vas a poder conseguir el doble de materiales de la cueva y piedra");
										}
									} else {
										i1 = i1-1;
									}
								}
							} else if(fabrica.equals("Hacha")) {
								if (hacha==true) {
									JOptionPane.showMessageDialog(null, "Ya tenés un hacha");
								} else {
									int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 80 de madera y 80 de piedra, ¿Queres gastarlos en esto?");
									if (pregunta1==0) {
										madera = madera - 80;
										piedra = piedra - 80;
										if (madera<0 || piedra<0) {
											madera = madera + 80;
											piedra = piedra + 80;
											JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
											i1 = i1-1;
										} else {
											hacha=true;
											JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu hacha, ahora vas a poder conseguir el doble de madera");
										}
									} else {
										i1 = i1-1;
									}
								}
							}
							
							break;
							
						case "Requisitos de la casa":
							int pregunta2 = JOptionPane.showConfirmDialog(null, "Necesitas 2000 de madera, 1400 de piedra, 100 de hierro y 50 diamantes, ¿queres ver cuántos materiales te faltan?");
							if (pregunta2==0) {
								int verMadera = 2000 - madera;
								int verPiedra = 1400 - piedra;
								int verHierro = 100 - hierro;
								int verDiamante = 50 - diamante;
								JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
							} else {
								i1 = i1-1;
							}
							break;
						
						default:
							break;
						}
							if (juegoTerminado==true) {
								break;
							}
					}
				} else if(hacha==true){
					JOptionPane.showMessageDialog(null, "Como solo tenés el hacha, vas a conseguir el doble de recompensa en la madera solamente");
					accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+i1+", ¿Qué querés hacer?", "Acción de noche",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/noche.jpg")), accionesNoche, accionesNoche[0]);
					switch (accion) {
					case "Ir a buscar materiales":
						material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
						if (material.equals("Madera")) {
							porcentajeNoche = (int)(Math.random()*10);
							if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
								JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
								juegoTerminado = true;
							}else {
								madera=(int)(Math.random()*150)+madera;
								JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
							}
							
						} else if(material.equals("Piedra")) {
							porcentajeNoche = (int)(Math.random()*10);
							if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
								JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
								juegoTerminado = true;
							}else {
								piedra=(int)(Math.random()*75)+piedra;
								JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
							}
							
						}
						break;
						
					case "Ir a explorar":
						int pregunta= JOptionPane.showConfirmDialog(null, "Tenés un 50% de probabilidad de morir, ¿Queres explorar igual?");
						if (pregunta==0) {
							JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
							porcentajeNoche= (int)(Math.random()*10);
							if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
								JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
								juegoTerminado = true;
							} else {
								hierro=(int)(Math.random()*15)+hierro;
								diamante=(int)(Math.random()*5)+diamante;
								JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
								JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));
							}
						} else {
							i1 = i1-1;
						}
						
						break;
					case "No hacer nada":
						JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
						break;
						
					case "Inventario":
						JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
						break;
						
					case "Fabricar":
						fabrica = (String)JOptionPane.showInputDialog(null, "Qué queres fabricar?", "Fabricacion",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/mesaCraf.png")), fabricacion, fabricacion[0]);
						if (fabrica.equals("Pico")) {
							if (pico==true) {
								JOptionPane.showMessageDialog(null, "Ya tenés un pico");
							} else {
								int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 80 de madera y 80 de piedra, ¿Queres gastarlos en esto?");
								if (pregunta1==0) {
									madera = madera - 80;
									piedra = piedra - 80;
									if (madera<0 || piedra<0) {
										madera = madera + 80;
										piedra = piedra + 80;
										JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
										i1 = i1-1;
									} else {
										pico=true;
										JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu pico, ahora vas a poder conseguir el doble de materiales de la cueva y piedra");
									}
								} else {
									i1 = i1-1;
								}
							}
						} else if(fabrica.equals("Hacha")) {
							if (hacha==true) {
								JOptionPane.showMessageDialog(null, "Ya tenés un hacha");
							} else {
								int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 80 de madera y 80 de piedra, ¿Queres gastarlos en esto?");
								if (pregunta1==0) {
									madera = madera - 80;
									piedra = piedra - 80;
									if (madera<0 || piedra<0) {
										madera = madera + 80;
										piedra = piedra + 80;
										JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
										i1 = i1-1;
									} else {
										hacha=true;
										JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu hacha, ahora vas a poder conseguir el doble de madera");
									}
								} else {
									i1 = i1-1;
								}
							}
						}
						
						break;
						
					case "Requisitos de la casa":
						int pregunta2 = JOptionPane.showConfirmDialog(null, "Necesitas 2000 de madera, 1400 de piedra, 100 de hierro y 50 diamantes, ¿Queres ver cuántos materiales te faltan?");
						if (pregunta2==0) {
							int verMadera = 2000 - madera;
							int verPiedra = 1400 - piedra;
							int verHierro = 100 - hierro;
							int verDiamante = 50 - diamante;
							JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
						} else {
							i1 = i1-1;
						}
						break;
					
					default:
						break;
					}
						if (juegoTerminado==true) {
							break;
						}
				} else {
					JOptionPane.showMessageDialog(null, "Como no tenés objetos fabricados, no vas a conseguir materiales extra");
					accion = (String)JOptionPane.showInputDialog(null, "Esta es la acción número "+i1+", ¿Qué queres hacer?", "Acción de noche",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/noche.jpg")), accionesNoche, accionesNoche[0]);
					switch (accion) {
					case "Ir a buscar materiales":
						material = (String)JOptionPane.showInputDialog(null, "¿Qué tipo de material queres buscar?", "Buscar materiales",0,null, materiales, materiales[0]);
						if (material.equals("Madera")) {
							porcentajeNoche = (int)(Math.random()*10);
							if (porcentajeNoche>=0 && porcentajeNoche<=2 ) {
								JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
								juegoTerminado = true;
							}else {
								madera=(int)(Math.random()*75)+madera;
								JOptionPane.showMessageDialog(null, "Ahora tenés: "+madera+" de madera", "Madera", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/madera.jpg")));
							}
							
						} else if(material.equals("Piedra")) {
							porcentajeNoche = (int)(Math.random()*10);
							if (porcentajeNoche>=0 && porcentajeNoche<=2 ) {
								JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
								juegoTerminado = true;
							}else {
								piedra=(int)(Math.random()*75)+piedra;
								JOptionPane.showMessageDialog(null, "Ahora tenés: "+piedra+" de piedra", "Piedra", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/piedra.jpg")));
							}
							
						}
						break;
						
					case "Ir a explorar":
							JOptionPane.showMessageDialog(null, "Fuiste a explorar", "Exploración", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cueva.jpg")));
							porcentajeNoche= (int)(Math.random()*10);
							if (porcentajeNoche>=0 && porcentajeNoche<=5 ) {
								JOptionPane.showMessageDialog(null, null, "Moriste", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/morir.png")));
								juegoTerminado = true;
							} else {
								hierro=(int)(Math.random()*15)+hierro;
								diamante=(int)(Math.random()*5)+diamante;
								JOptionPane.showMessageDialog(null, "Tenés "+hierro+" de hierro", "Hierro", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/hierro.jpg")));
								JOptionPane.showMessageDialog(null, "Tenés "+diamante+" de diamante", "Diamante", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/diamante.png")));
							}
						
						break;
					case "No hacer nada":
						JOptionPane.showMessageDialog(null, "No hiciste nada", "No hiciste nada", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/nada.jpg")));
						break;
						
					case "Inventario":
						JOptionPane.showMessageDialog(null, "Madera: "+madera+"\n"+"Piedra: "+piedra+"\n"+"Hierro: "+hierro+"\n"+"Diamante: "+diamante, "Inventario", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/inventario.png")));
						break;
						
					case "Fabricar":
						fabrica = (String)JOptionPane.showInputDialog(null, "Qué queres fabricar?", "Fabricacion",JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/mesaCraf.png")), fabricacion, fabricacion[0]);
						if (fabrica.equals("Pico")) {
							if (pico==true) {
								JOptionPane.showMessageDialog(null, "Ya tenés un pico");
							} else {
								int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 80 de madera y 80 de piedra, ¿Queres gastarlos en esto?");
								if (pregunta1==0) {
									madera = madera - 80;
									piedra = piedra - 80;
									if (madera<0 || piedra<0) {
										madera = madera + 80;
										piedra = piedra + 80;
										JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
										i1 = i1-1;
									} else {
										pico=true;
										JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu pico, ahora vas a poder conseguir el doble de materiales de la cueva y piedra");
									}
								} else {
									i1 = i1-1;
								}
							}
						} else if(fabrica.equals("Hacha")) {
							if (hacha==true) {
								JOptionPane.showMessageDialog(null, "Ya tenés un hacha");
							} else {
								int pregunta1 = JOptionPane.showConfirmDialog(null, "Necesitas 80 de madera y 80 de piedra, ¿Queres gastarlos en esto?");
								if (pregunta1==0) {
									madera = madera - 80;
									piedra = piedra - 80;
									if (madera<0 || piedra<0) {
										madera = madera + 80;
										piedra = piedra + 80;
										JOptionPane.showMessageDialog(null, "No tenés suficientes materiales para hacer esto");
										i1 = i1-1;
									} else {
										hacha=true;
										JOptionPane.showMessageDialog(null, "Felicitaciones, tenés tu hacha, ahora vas a poder conseguir el doble de madera");
									}
								} else {
									i1 = i1-1;
								}
							}
						}
						
						break;
						
					case "Requisitos de la casa":
						int pregunta2 = JOptionPane.showConfirmDialog(null, "Necesitas 2000 de madera, 1400 de piedra, 100 de hierro y 50 diamantes, ¿Queres ver cuántos materiales te faltan?");
						if (pregunta2==0) {
							int verMadera = 2000 - madera;
							int verPiedra = 1400 - piedra;
							int verHierro = 100 - hierro;
							int verDiamante = 50 - diamante;
							JOptionPane.showMessageDialog(null, "Materiales que te faltan: \n"+"Madera: "+verMadera+"\n"+"Piedra: "+verPiedra+"\n"+"Hierro: "+verHierro+"\n"+"Diamante: "+verDiamante);
						} else {
							i1 = i1-1;
						}
						break;
					
					default:
						break;
					}
						if (juegoTerminado==true) {
							break;
						}
				}
			}
			if (madera>=2000 && piedra>=1400 && hierro>=100 && diamante>=50) {
				JOptionPane.showMessageDialog(null, "Conseguiste armar tu casa!! Felicidades", "Ganaste!!", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/casa.jpg")));
				juegoTerminado=true;
			};
		}while (juegoTerminado==false);
		JOptionPane.showMessageDialog(null, "Nombre: "+nombre+"\n"+"Estuviste con vida: "+contDia+" dias"+"\n"+"Madera obtenida: "+madera+"\n Piedra obtenida: "+piedra+"\n Hierro obtenido: "+hierro+"\n Diamante obtenido: "+diamante+"\n"+"Conseguiste fabricar el hacha: "+hacha+"\n"+"Conseguiste fabricar el pico: "+pico);
	}
	
}

