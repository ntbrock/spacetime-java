package spacetime;

public /**
 * This is the "data point" for the world-line.
 */
class WorldlineRecord{
  double t, x, betaNew, betaOld;
  Scenario sc;
  
  public WorldlineRecord(Scenario sc, double xp, double tp, double betapOld, double betapNew){
    this.sc=sc;
    setXpTpBetapOldNew(xp, tp, betapOld, betapNew);
  }
  
  public void setXpTpBetapOldNew(double xp, double tp, double betapOld, double betapNew){
    double betaRel = sc.getBetaRel();
    // Implementation of Einstein 2nd Postulate ??
    if(betapNew>1) betapNew=1;
    else if(betapNew<-1) betapNew=-1;
    // Velocity Addition (from Wikipedia)
    this.betaNew = (betapNew+betaRel)/(1+betapNew*betaRel);

    // Implementation of Einstein 2nd Postulate ??
    if(betapOld>1) betapOld=1;
    else if(betapOld<-1) betapOld=-1;
    // Velocity Addition (from Wikipedia)
    this.betaOld = (betapOld+betaRel)/(1+betapOld*betaRel);
    
    
    double gammaRel=1/Math.sqrt(1-betaRel*betaRel);  // Equation 1.22 from Modern Physics
    // Inverse Lorentz coordinate transformation
    // where the sign of u has been changed to take into account the difference in direction of motion of the two frames.
    this.x = gammaRel*(xp + betaRel*tp); // Equation 1.17
    this.t = gammaRel*(tp + betaRel*xp);
  }

  // Xp = X Prime
  public double getXp(){
    double betaRel = sc.getBetaRel();
    double gammaRel = 1/Math.sqrt(1-betaRel*betaRel);
    return gammaRel*(x-betaRel*t); // Equation 1.23
  }

  // Tp = T Prime
  public double getTp(){
    double betaRel = sc.getBetaRel();
    double gammaRel = 1/Math.sqrt(1-betaRel*betaRel);
    return gammaRel*(t-betaRel*x); // Equation 1.26
  }
  
  public double getBetaPOld(){
    double betaRel = sc.getBetaRel();
    return (betaOld-betaRel)/(1-betaOld*betaRel); // Velocity Subtraction - Like Wiki, but subtracted
  }
  
  public double getBetaPNew(){
    double betaRel = sc.getBetaRel();
    return (betaNew-betaRel)/(1-betaNew*betaRel);
  }
  
  
}