package Lisa;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Bodian.Circuit;
import Bodian.TrainBis;
import Bodian.Wagon;
import Guoyu.Aguillage;
import Guoyu.Gare;
import Guoyu.Position;
import Thomas.Jeu;

public class MonJPanelDessin extends JPanel{

	private BufferedImage image=null;
	private Jeu jeu;
	private String sNomImage;
	private JPanel panelDessin = this;
	private Hashtable<JButtonAiguillage,Aguillage> rechercheAiguilage = new Hashtable<JButtonAiguillage,Aguillage>();
	private Hashtable<JSpinnerRetard,Wagon> rechercheRetard = new Hashtable<JSpinnerRetard,Wagon>();
	private boolean configTerminer;
	private Image ImLocomotiveGauche;
	private Image ImLocomotiveDroit;
	private Image ImLocomotiveHaut;
	private Image ImLocomotiveBas;
	private Image ImWagonHorizontale;
	private Image ImWagonHaut;
	private Image ImWagonBas;
	private Image ImRailVirageBasDroit;
	private Image ImRailVirageBasGauche;
	private Image ImRailVirageHautDroit;
	private Image ImRailVirageHautGauche;
	private Image ImRailHorizontale;
	private Image ImRailVerticale;
	private Image ImGare;
	private Image ImFondGame;
	private Image ImLocomotive;
	private Image ImWagon;
	private Image ImRail;
	private boolean config;
	
	public MonJPanelDessin(Jeu jeu) 
	{
		this.setLayout(null);
		this.jeu = jeu;
		this.config = false;
		this.configTerminer = false;
		try {
			ImLocomotiveGauche=ImageIO.read(new File("images/LocomotiveGauche.png"));
			ImLocomotiveDroit=ImageIO.read(new File("images/locomotiveDroit.png"));
			ImLocomotiveHaut=ImageIO.read(new File("images/locomotiveHaut.png"));
			ImLocomotiveBas=ImageIO.read(new File("images/locomotiveBas.png"));
			ImWagonHorizontale=ImageIO.read(new File("images/WagonHorizontale.png"));
			ImWagonHaut=ImageIO.read(new File("images/WagonHaut.png"));
			ImWagonBas=ImageIO.read(new File("images/WagonBas.png"));
			ImGare=ImageIO.read(new File("images/Gare.png"));
			ImRailVirageBasDroit=ImageIO.read(new File("images/RailVirageBasDroit.png"));
			ImRailVirageBasGauche=ImageIO.read(new File("images/RailVirageBasGauche.png"));
			ImRailVirageHautDroit=ImageIO.read(new File("images/RailVirageHautDroit.png"));
			ImRailVirageHautGauche=ImageIO.read(new File("images/RailVirageHautGauche.png"));
			ImRailHorizontale=ImageIO.read(new File("images/RailHorizontale.png"));
			ImRailVerticale=ImageIO.read(new File("images/RailVerticale.png"));
			ImFondGame=ImageIO.read(new File("images/Fond-Game.png"));
			ImLocomotive = null;
			ImRail = null;
			ImWagon=null;
		}catch (IOException e) {
			e.printStackTrace();
		}
	}	
				

	
	public void initButtonAiguillage(double dxParam, double dyParam) throws IOException
	{
		double dx = dxParam;
		double dy = dyParam;
		int dxInt = (int) dx;
		int dyInt = (int) dy;
		ImageIcon iconHozizontal = new ImageIcon(new ImageIcon("images/RailHorizontale.png").getImage().getScaledInstance(dxInt, dyInt, Image.SCALE_DEFAULT));
		ImageIcon iconVerticale = new ImageIcon(new ImageIcon("images/RailVerticale.png").getImage().getScaledInstance(dxInt, dyInt, Image.SCALE_DEFAULT));
		
		if(!config)
		{
			for(int i=0; i< jeu.getListeAiguillage().size(); i++)
			{
				
				Aguillage aiguil = jeu.getListeAiguillage().get(i);
				JButtonAiguillage btn = new JButtonAiguillage(i);
				btn.setBackground(Color.green);
				btn.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) 
				    {
				    	Object  source=e.getSource();				    	
				    	Aguillage aig = rechercheAiguilage.get(source);				    	
				    	aig.changeposition();
				    	panelDessin.revalidate();
				    	panelDessin.repaint();
				    }
				});
				
				btn.setBounds((int)(aiguil.getPositionAiguillage().getPosX()*dx), (int)(aiguil.getPositionAiguillage().getPosY()*dy),(int)dx,(int)dy);
				rechercheAiguilage.put(btn, aiguil);
				this.add(btn);
			}
			
			for(int train=0 ; train< jeu.getListeGare().size(); train++)
			{
				TrainBis trainActuelle = jeu.getListeTrain().get(train);
				Wagon wagonActuelle = trainActuelle.getListWagon().getLast();
				JSpinnerRetard spinretard = new JSpinnerRetard(train);
				spinretard.setModel(new SpinnerNumberModel(0, 0, 5, 1));
				int newretard = (Integer)spinretard.getValue();
				trainActuelle.setRetard(newretard);
				spinretard.setBounds((int)(wagonActuelle.getPosWagon().getPosX()*dx), (int)(wagonActuelle.getPosWagon().getPosY()*dy),(int)dx,(int)dy);	
				rechercheRetard.put(spinretard, wagonActuelle);
				spinretard.addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent e) 
					{
						int retard = (Integer)spinretard.getValue();
						trainActuelle.setRetard(retard);			
					}
					
				});
				this.add(spinretard);
			}
			
			config = true;
			
		}
		else 
		{
			 Enumeration<JButtonAiguillage> e = rechercheAiguilage.keys();
			 
		       while (e.hasMoreElements()) 
		       {
		 
		           // Getting the key of a particular entry
		           JButtonAiguillage key = e.nextElement();
		           Aguillage aiguil = rechercheAiguilage.get(key);		          		           		           		            
		           if(aiguil.getDirectionHorizontale() == false) 
		           {
		           	//key.setBackground(Color.magenta);
		           	key.setIcon(iconVerticale);
		           }
		           else 
		           {
		        	   //key.setBackground(Color.black);
		            	key.setIcon(iconHozizontal);
		           }
		            
		            key.setBounds((int)(aiguil.getPositionAiguillage().getPosX()*dx), (int)(aiguil.getPositionAiguillage().getPosY()*dy),(int)dx,(int)dy);
		            key.revalidate();
		            key.repaint();
		       }
		       
		       Enumeration<JSpinnerRetard> retard = rechercheRetard.keys();
				 
		       while (retard.hasMoreElements()) 
		       {
		 
		           // Getting the key of a particular entry
		    	   JSpinnerRetard key = retard.nextElement();
		           Wagon wagon = rechercheRetard.get(key);		          		           		           		            	            
		           key.setBounds((int)(wagon.getPosWagon().getPosX()*dx), (int)(wagon.getPosWagon().getPosY()*dy),(int)dx,(int)dy);	
		           key.revalidate();
		           key.repaint();
		       }
		}
		
	
	}
						
			
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(ImFondGame, 0,0, this.getWidth(), this.getHeight(),null);
		
		if(jeu!=null) 
		{
			double dx = this.getWidth()/(double)jeu.getTailleX();
			double dy = this.getHeight()/(double)jeu.getTailleY();	
			
			if(!configTerminer)
			{
				try 
				{
					initButtonAiguillage(dx,dy);
				} catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Position Rail
			for(int circuit=0; circuit<jeu.getListeCircuit().size(); circuit++)
			{
				Circuit circuitActuelle = jeu.getListeCircuit().get(circuit);
				
				//Debut boucle Position
				for(int indexPos=0; indexPos < circuitActuelle.getposcircuit().size(); indexPos++)
				{
					//Préparation 3 position d'affilé
					
					Position pos0 = null;
					Position pos1 = circuitActuelle.getposcircuit().get(indexPos);
					Position pos2 = null;
					
					if(indexPos-1 >= 0) 
					{
						pos0 = circuitActuelle.getposcircuit().get(indexPos-1);
					}
					else
					{
						pos0 = circuitActuelle.getposcircuit().getLast();
					}
					
					if(indexPos+1 < circuitActuelle.getposcircuit().size()) 
					{
						pos2 = circuitActuelle.getposcircuit().get(indexPos+1);
					}
					else
					{
						pos2 = circuitActuelle.getposcircuit().get(0);
					}
					
					if(!isAiguillage(pos1))
					{
						//Vérification placement
						if(pos1.getPosY() != pos0.getPosY() || pos1.getPosY() != pos2.getPosY())
						{
							Position posGauche = new Position(pos1.getPosX()-1,pos1.getPosY());
							Position posDroite = new Position(pos1.getPosX()+1,pos1.getPosY());
							Position posHaut = new Position(pos1.getPosX(),pos1.getPosY()-1);
							Position posBas = new Position(pos1.getPosX(),pos1.getPosY()+1);
							
							//PremierCas
							if(pos2.equals(posGauche) && pos0.equals(posBas))
							{
								g.drawImage(ImRailVirageBasGauche,(int)(pos1.getPosX()*dx), 
										(int)(pos1.getPosY()*dy), 
										(int)dx, (int)dy, null);
							}
							else if(pos2.equals(posGauche) && pos0.equals(posHaut))
							{
								g.drawImage(ImRailVirageBasDroit,(int)(pos1.getPosX()*dx), 
										(int)(pos1.getPosY()*dy), 
										(int)dx, (int)dy, null);
							}
							else if(pos2.equals(posDroite) && pos0.equals(posBas))
							{
								g.drawImage(ImRailVirageHautGauche,(int)(pos1.getPosX()*dx), 
										(int)(pos1.getPosY()*dy), 
										(int)dx, (int)dy, null);
							}
							else if(pos2.equals(posDroite) && pos0.equals(posHaut))
							{
								g.drawImage(ImRailVirageBasDroit,(int)(pos1.getPosX()*dx), 
										(int)(pos1.getPosY()*dy), 
										(int)dx, (int)dy, null);
							}
							//DeuxiemeCas
							else if(pos2.equals(posHaut) && pos0.equals(posDroite))
							{
								g.drawImage(ImRailVirageBasGauche,(int)(pos1.getPosX()*dx), 
										(int)(pos1.getPosY()*dy), 
										(int)dx, (int)dy, null);
							}
							else if(pos2.equals(posHaut) && pos0.equals(posGauche))
							{
								g.drawImage(ImRailVirageBasDroit,(int)(pos1.getPosX()*dx), 
										(int)(pos1.getPosY()*dy), 
										(int)dx, (int)dy, null);
							}
							else if(pos2.equals(posBas) && pos0.equals(posDroite))
							{
								g.drawImage(ImRailVirageHautGauche,(int)(pos1.getPosX()*dx), 
										(int)(pos1.getPosY()*dy), 
										(int)dx, (int)dy, null);
							}
							else if(pos2.equals(posBas) && pos0.equals(posGauche))
							{
								g.drawImage(ImRailVirageHautDroit,(int)(pos1.getPosX()*dx), 
										(int)(pos1.getPosY()*dy), 
										(int)dx, (int)dy, null);
							}
							else
							{
								g.drawImage(ImRailVerticale,(int)(pos1.getPosX()*dx), 
										(int)(pos1.getPosY()*dy), 
										(int)dx, (int)dy, null);
							}
						}
						else 
						{ 
							g.drawImage(ImRailHorizontale,(int)(pos1.getPosX()*dx), 
									(int)(pos1.getPosY()*dy), 
									(int)dx, (int)dy, null);
						}
					}
					
				}
				//Fin boucle Position													
			}			
			
			for(int train=0 ; train< jeu.getListeTrain().size(); train++)
			{
				TrainBis trainActuelle = jeu.getListeTrain().get(train);
				sensLocomotive(trainActuelle);
				sensWagon(trainActuelle);
				
				
						
				for(int wagon=0 ; wagon< trainActuelle.getListWagon().size(); wagon++)
				{
					Wagon wagonActuelle = trainActuelle.getListWagon().get(wagon);
					
					if(trainActuelle.getListWagon().size() == 3)
					{						
						if(wagonActuelle == trainActuelle.getListWagon().get(2))
						{
							g.drawImage(ImLocomotive,(int)(wagonActuelle.getPosWagon().getPosX()*dx), 
										(int)(wagonActuelle.getPosWagon().getPosY()*dy), 
										(int)dx, (int)dy, null);
						}
						if(wagonActuelle != trainActuelle.getListWagon().get(2))
						{
							g.drawImage(ImWagon,(int)(wagonActuelle.getPosWagon().getPosX()*dx), 
										(int)(wagonActuelle.getPosWagon().getPosY()*dy), 
										(int)dx, (int)dy, null);
						}												
					}
					
					if(trainActuelle.getListWagon().size() == 2)
					{	
						if(wagonActuelle == trainActuelle.getListWagon().get(1))
						{
							g.drawImage(ImLocomotive,(int)(wagonActuelle.getPosWagon().getPosX()*dx), 
										(int)(wagonActuelle.getPosWagon().getPosY()*dy), 
										(int)dx, (int)dy, null);
						}
						if(wagonActuelle != trainActuelle.getListWagon().get(1))
						{
							g.drawImage(ImWagon,(int)(wagonActuelle.getPosWagon().getPosX()*dx), 
										(int)(wagonActuelle.getPosWagon().getPosY()*dy), 
										(int)dx, (int)dy, null);
						}
						
					}
					
					if(trainActuelle.getListWagon().size() == 1)
					{
						if(trainActuelle.getDessinTrain()==false)
						{
							if(wagonActuelle == trainActuelle.getListWagon().get(0))
							{
								g.drawImage(ImLocomotive,(int)(wagonActuelle.getPosWagon().getPosX()*dx), 
											(int)(wagonActuelle.getPosWagon().getPosY()*dy), 
											(int)dx, (int)dy, null);
							}	
						}
															
					}															
				}
			}
			for(int gare=0; gare<jeu.getListeGare().size(); gare++)
			{
				Gare gareActuelle = jeu.getListeGare().get(gare);
				g.drawImage(ImGare,(int)(gareActuelle.getPosGare().getPosX()*dx), 
						(int)(gareActuelle.getPosGare().getPosY()*dy), 
						(int)dx, (int)dy, null);
			}
			
			if(configTerminer)
			{
				for(int i=0; i<jeu.getListeAiguillage().size(); i++)
				{				
					Aguillage aiguillage = jeu.getListeAiguillage().get(i);
					
					if(aiguillage.getDirectionHorizontale() == true) 
					{
						g.drawImage(ImRailHorizontale,(int)(aiguillage.getPositionAiguillage().getPosX()*dx), 
							(int)(aiguillage.getPositionAiguillage().getPosY()*dy), 
							(int)dx, (int)dy, null);
					}
					
					if(aiguillage.getDirectionHorizontale() == false) 
					{
						g.drawImage(ImRailVerticale,(int)(aiguillage.getPositionAiguillage().getPosX()*dx), (int)(aiguillage.getPositionAiguillage().getPosY()*dy), (int)dx, (int)dy, null);
					}
					
				}
			}
			
	
			 //System.out.println("affiche");
		}
	}	
	
	//Méthode pour le sens des locomotives.
	
	public void sensLocomotive(TrainBis trainActuelle)
	{								
			
		for(int wagon=0; wagon < trainActuelle.getListWagon().size(); wagon++)
		{
			Wagon wagonActuelle = trainActuelle.getListWagon().get(wagon);
			
			Position posActuelle= wagonActuelle.getPosWagon();
			Position posAvant= wagonActuelle.getPosWagonAvant();
				
			if(posAvant!=null)
			{
				if(posActuelle.getPosX() == posAvant.getPosX())
				{
					if(posActuelle.getPosY()-posAvant.getPosY() == 1)
					{
						ImLocomotive = ImLocomotiveBas;
					}
					if(posActuelle.getPosY()-posAvant.getPosY() == -1)
					{
						ImLocomotive = ImLocomotiveHaut;
					}
				}
						
				if(posActuelle.getPosX() != posAvant.getPosX())
				{
					if(posActuelle.getPosX()-posAvant.getPosX() == 1)
					{
						ImLocomotive = ImLocomotiveDroit;
					}
					if(posActuelle.getPosX()-posAvant.getPosX() == -1)
					{
						ImLocomotive = ImLocomotiveGauche;
					}
				}
			}
			else 
			{
				ImLocomotive = ImLocomotiveDroit;
			}				
		}														
}		
	
	public boolean isAiguillage(Position posParam)
	{
		boolean flag = false;
		for(int aiguillage=0; aiguillage< jeu.getListeAiguillage().size();aiguillage++)
		{
			Position posAiguillage = jeu.getListeAiguillage().get(aiguillage).getPositionAiguillage();
			if(posParam.equals(posAiguillage))
			{
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean isConfigTerminer() {
		return configTerminer;
	}



	public void setConfigTerminer(boolean configTerminer) {
		this.configTerminer = configTerminer;
	}
	
	
	public void sensWagon(TrainBis trainActuelle)
	{
		for(int wagon=0; wagon < trainActuelle.getListWagon().size(); wagon++)
		{
			Wagon wagonActuelle = trainActuelle.getListWagon().get(wagon);
			if(wagonActuelle != trainActuelle.getListWagon().getLast() )
			{
				Position posActuelle= wagonActuelle.getPosWagon();
				Position posAvant= wagonActuelle.getPosWagonAvant();
				
				if(posAvant!=null)
				{
					if(posActuelle.getPosX() == posAvant.getPosX())
					{
						if(posActuelle.getPosY()-posAvant.getPosY() == 1)
						{
							ImWagon = ImWagonBas;
						}
						if(posActuelle.getPosY()-posAvant.getPosY() == -1)
						{
							ImWagon = ImWagonHaut;
						}
					}
						
					if(posActuelle.getPosX() != posAvant.getPosX())
					{
						if(posActuelle.getPosX()-posAvant.getPosX() == 1)
						{
							ImWagon = ImWagonHorizontale;
						}
						if(posActuelle.getPosX()-posAvant.getPosX() == -1)
						{
							ImWagon = ImWagonHorizontale;
						}
					}
				}
				else 
				{
					ImWagon = ImWagonHorizontale;
				}
			}
					
		}					
	}
}


		
	

