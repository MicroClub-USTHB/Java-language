
package com.usthb.dessin;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Potence extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int etat=0;
	boolean trouve=false;
	Dimension di;
	
	public void incermantEtat() {
		this.etat +=1;
		
	}
	
	public void setTrouve(boolean trouve) {
		this.trouve=trouve;
	}
	
	public int getetat() {
		return this.etat;
	}
	public void getsize() {
		di=new Dimension(this.getWidth(),this.getHeight());
	}
	
	public void restart() {
		this.etat=0;
		this.trouve=false;
	}
	
	public void paint (Graphics g)
	{
	
	di = getSize(); 
	g.clearRect(0, 0, di.width-1, di.height-1);
	g.drawRect(0, 0, di.width-1, di.height-1);
	int taille = 12*(di.width/120)-2;
	if (taille <8)
	taille = 8;
	g.setFont(new Font("TimesRoman", Font.PLAIN,taille ));
	if (etat >= 1) g.drawLine(l(30), h(120), l(90), h(120));
	if (etat >= 2) g.drawLine(l(30), h(120), l(30), h(40));
	if (etat >= 3) g.drawLine(l(60), h(120), l(30), h(90));
	if (etat >= 4) g.drawLine(l(30), h(40), l(80), h(40));
	if (etat >= 5) g.drawLine(l(30), h(60), l(50), h(40));
	if (etat >= 6) g.drawLine(l(70), h(40), l(70), h(60));
	if (etat >= 7) g.drawOval(l(65), h(60), l(10), h(10)); // tête
	if (etat >= 8)
	{
	g.drawLine(l(70), h(70), l(70), h(85)); // corps
	g.drawLine(l(70), h(70), l(65), h(75)); // corps
	g.drawLine(l(70), h(70), l(75), h(75)); // corps
	g.drawLine(l(70), h(85), l(65), h(95)); // corps
	g.drawLine(l(70), h(85), l(75), h(95)); // corps
	
}
	if (trouve) g.drawString("Bravo! vous avez trouvé", l(10), h(150));
	else if (etat == 8) g.drawString("Vous êtes pendu !", l(10), h(150));
	else if (etat == 7)
	g.drawString("Reste un coup à jouer !", l(10), h(150));
	else
	g.drawString("Reste "+(8-etat)+"coups à jouer", l(10), h(150));
	}
	
	int l (int v)
	{
	double k = Math.min(di.width/140., di.height/160);
	return (int)(v*k);
	}
	
	int h (int v)
	{
	double k = Math.min(di.width/140., di.height/160);
	return (int)(v*k);
	}
	
	
	}