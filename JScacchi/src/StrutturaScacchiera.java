import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import struttura.*;


public class StrutturaScacchiera extends JPanel{

	private static final long serialVersionUID=1L;
	private Pezzo[][] scacchiera=new Pezzo[8][8];
	private JPanel tavolo=new JPanel();
	private JLabel coordinate_col[]=new JLabel[8];
	private JPanel coordinateColonna=new JPanel();
	private JLabel coordinate_rig[]=new JLabel[9];
	private JPanel coordinateRiga=new JPanel();
	private JLabel ped_mangiate_bianche[]=new JLabel[16];
    private JLabel ped_mangiate_nere[]=new JLabel[16];
    private JPanel pedineMangiate=new JPanel();
    private JLabel mossa = new JLabel();
    private JPanel contatoreMosse = new JPanel();
    final StrutturaScacchiera obj = this;
    private int cont_mosse=0;
    private Info stato;
    private Pezzo pezzo_attesa;
	
	public StrutturaScacchiera(){
		this.setLayout(new BorderLayout());
		setScacchiera();
		struttura();
		stato = Info.TURNO_BIANCHI; // 1° TURNO DEI BIANCHI
	}
	
	private void struttura(){
		
		//coordinate colonna
		
		coordinateColonna.setLayout(new FlowLayout());
		JLabel vuoto=new JLabel("PEZZI MANGIATI");
        vuoto.setHorizontalAlignment(2);
        vuoto.setForeground(java.awt.Color.decode("#ffffb3"));
        JLabel vuoto1=new JLabel("");
        vuoto.setPreferredSize(new Dimension(100,30));
        vuoto1.setPreferredSize(new Dimension(57,30));
        coordinateColonna.add(vuoto1);
        for(int i=0;i<8;i++){
            coordinate_col[i]=new JLabel(""+(char)(i+65)); 
            coordinate_col[i].setHorizontalAlignment(JLabel.CENTER);
            coordinate_col[i].setHorizontalAlignment(2);
            coordinate_col[i].setPreferredSize(new Dimension(70, 30));
            coordinate_col[i].setForeground(java.awt.Color.decode("#ffffb3"));
            coordinateColonna.add(coordinate_col[i]);
            coordinateColonna.setBackground(java.awt.Color.decode("#762825"));
        }         
        coordinateColonna.add(vuoto);
        
        //coordinate riga
        
		coordinateRiga.setLayout(new GridLayout(8,1));
		coordinateRiga.setPreferredSize(new Dimension(40,70));
		for(int i=0;i<8;i++){
            coordinate_rig[i]=new JLabel(""+(i+1));
            coordinate_rig[i].setHorizontalAlignment( JLabel.CENTER );
            coordinate_rig[i].setForeground(java.awt.Color.decode("#ffffb3"));
            coordinateRiga.add(coordinate_rig[i]);
            coordinateRiga.setBackground(java.awt.Color.decode("#762825"));
        }
		
		// pedine mangiate
		
		pedineMangiate.setLayout(new GridLayout(16,2));
		for(int i=0;i<16;i++){
            ped_mangiate_bianche[i]=new JLabel();
            ped_mangiate_nere[i]=new JLabel();
            ped_mangiate_bianche[i].setHorizontalAlignment( JLabel.CENTER );
            ped_mangiate_nere[i].setHorizontalAlignment( JLabel.CENTER );
            ped_mangiate_bianche[i].setPreferredSize(new Dimension(70, 40));
            ped_mangiate_nere[i].setPreferredSize(new Dimension(70, 40));
            pedineMangiate.add(ped_mangiate_bianche[i]);
            pedineMangiate.add(ped_mangiate_nere[i]);
            pedineMangiate.setBackground(java.awt.Color.decode("#762825"));
        }
		
		// contatore mosse
		
		contatoreMosse.setLayout(new FlowLayout(FlowLayout.LEADING,42,0));
        mossa.setText("MOSSE PARTITA: " + cont_mosse);
        mossa.setPreferredSize(new Dimension(200,45));
        mossa.setForeground(java.awt.Color.decode("#ffffb3"));
        contatoreMosse.add(mossa);
        contatoreMosse.setBackground(java.awt.Color.decode("#762825"));
		
		// aggiunta elementi a pannello
		
		add(coordinateColonna,BorderLayout.NORTH);
		add(coordinateRiga,BorderLayout.WEST);
		add(pedineMangiate,BorderLayout.EAST);
		add(contatoreMosse,BorderLayout.SOUTH);
	}
	
	private void setScacchiera(){
		tavolo.setLayout(new GridLayout(8,8));
		Colore tmp_colore;
		int riga,colonna;
		for(riga=0;riga<8;riga++){
			for(colonna=0;colonna<8;colonna++){
				tmp_colore=(riga>=6) ? Colore.BIANCO : Colore.NERO;
				if(riga==0 || riga==7){
	                if(colonna==0 || colonna==7){
	                    (scacchiera[riga][colonna])=new Torre(tmp_colore);
	                }else if(colonna==1 || colonna==6){
	                    (scacchiera[riga][colonna])=new Cavallo(tmp_colore);
	                }else if(colonna==2 || colonna==5){
	                    (scacchiera[riga][colonna])=new Alfiere(tmp_colore);
	                }else if(colonna==3){
	                    (scacchiera[riga][colonna])=new Regina(tmp_colore);
	                }else if(colonna==4){
	                    (scacchiera[riga][colonna])=new Re(tmp_colore);
	                }
	            }
				else if(riga==1 || riga==6){
					(scacchiera[riga][colonna])=new Pedone(tmp_colore);
				}
	            else{
	            	scacchiera[riga][colonna]=new Vuoto(tmp_colore);
	            }
				// INVERTITO COLONNA - RIGA
				scacchiera[riga][colonna].setLocation(colonna,riga);
				// MOVIMENTI
				scacchiera[riga][colonna].addActionListener(new MonitorAzioni(obj));
				
				tavolo.add(scacchiera[riga][colonna]);
				if(riga%2==0){
	                if(colonna%2==0){
	                    scacchiera[riga][colonna].setBackground(Color.decode("#f6d5a5"));
	                }else{
	                    scacchiera[riga][colonna].setBackground(Color.decode("#c46f38"));
	                }
	            }else{
	                if(colonna%2!=0){
	                    scacchiera[riga][colonna].setBackground(Color.decode("#f6d5a5"));
	                }else{
	                    scacchiera[riga][colonna].setBackground(Color.decode("#c46f38"));
	                }
	            }
			}
		}
		add(tavolo);
	}
	
	protected void resetScacchiera(){
		remove(tavolo);
		tavolo.removeAll();
		tavolo.updateUI();
		setScacchiera();
		revalidate();
		repaint();
		cont_mosse = 0;
		mossa.setText("MOSSE PARTITA: " + cont_mosse);
	}
	
	protected void incrementaMosse(){
		cont_mosse++;
		mossa.setText("MOSSE PARTITA: " + cont_mosse);
	}
	
	protected Pezzo[][] getTavolo(){
		return scacchiera;
	}
	
	protected Info getStato(){
		return stato;
	}
	
	protected void setStato(Info stato){
		this.stato = stato;
	}
	
	protected Pezzo getPzAttesa(){
		return pezzo_attesa;
	}
	
	protected void setPzAttesa(Pezzo pezzo_attesa){
		this.pezzo_attesa=pezzo_attesa;
	}
	
	protected void aggiornaScacchiera(){
		tavolo.updateUI();
		tavolo.revalidate();
		revalidate();
		repaint();
	}
}