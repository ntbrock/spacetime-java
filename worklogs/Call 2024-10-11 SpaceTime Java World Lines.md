Call 2024-10-11 SpaceTime Java 

Taylor Zoom https://us02web.zoom.us/j/8437083840?pwd=MGkyeXIzMElDaE1vVm9xNzlDK0lEZz09
 
## Next Actions 9/27

* Dr. Bennett> Share pages to read on Worldlines. Continue to think about the Screenshots being embedded in the Course Material.

	Postition time graphs - with Sonic Ranges.
	On position time graph, the slope tells graph.
	On time-vs-position graph slide tells.
		reciprocal velicty, dT / dX is the slope.

	Slope on this graph tells, 1 divided by velocity.
	Think about objects startgingat bottom of grpah and them move up in time.

	Slope of 1 dT / dX = for light.

	1424. What are the ct' and x' (prime) lines?  Different reference frame from length contraction and time dialation. Take perpindicular axles and angle them toards each other.

Horiztonal lines are all simultaneous in the same reference frame.

put numbers on aexes to know the coordinates of the event are in two refernces frames.

1432. 
Euclidian Coordinates - (x2-x1)^2 + (y2-y1)^2

Just rotating coordinate systems. Doesn't change distances.
Spacetime interval 

Looks lke a pythagorean right triangle.

Why Minus? Taylor can't tell it clearly.

Einstein 2 postulates?

Postulate 1 - All laws of physics shoudl have the same properties in all reference frames.  Law  of conservation of momentum has to eb true.
Fnet = MA

Postulate 2 - No matter what reference frame you observe from, the speed of light will always be the same. (The radical one)

Hint - There's only one mathematical transformation of cooridnates between refernce frames that cause postualate 2 to be correct.

To make sure speed of light is the same in all reference points. 
Everything else follows form that fact
the Lorentz traansformation.
A unique transformation that makes all reference frames compatible.

The math is cool.

Brandon - dS^2 always has to be positives?  two events separated in a causal way.  

If event 2 is in the futuer of event 1.  Then sapcetime interval has to be positive.

Event 0 could cause event w.

Get a positive slope. - "time-like interval".

Would get a negative number, a "space-like interval".

third is a "light-like interval".  The 45 degree slope line.

The space part of the interval is greater than the time part of the interval.

1451. 
Information traveling by quantum entanglement.  Status dependency.
measure teh status of particle, causes the other particle to be known.

Even thought something happend.

Related to causality - a different phenomenon. We don't know what the value of my partiple spin is until I measure it. 
Deal w/ entangled particples, meausing one cause the other one to ahve a diffn spin.  No information sent <--- 

? Do the measure ments at the same time.  

Can think about causality of space time diagrams.


Next Time = Coordinate Translation Code.
	
* Dr. Bennett > Mathematics of lorentz translations

* Devs> Review the Spacetime Calculations called Worldline Records.  Start with code in src/test/java/spacetime/ScenarioLoadFromFileTest, lines 128 - 130 where the Java calculations are called.

* All> Review the Java of WorldlineRecord.java

  
  public double getXp(){
    double betaRel = sc.getBetaRel();
    double gammaRel = 1/Math.sqrt(1-betaRel*betaRel);
    return gammaRel*(x-betaRel*t);
  }
  
  public double getTp(){
    double betaRel = sc.getBetaRel();
    double gammaRel = 1/Math.sqrt(1-betaRel*betaRel);
    return gammaRel*(t-betaRel*x);
  }
  




= Taylor + Brandon> Session + dev environments match.

= Brandon> Git Pull, Run the example and spacetime Unit Tests in IntelliJ.
 
 
## Next Meetings
 
- October 4: No Meeting, Fall Break
 
- October 11th: Full Team
 
- October 18: Developers, Dr. Bennett will be at a physics conference.
	Brandon going too!  NC, VA, MD, of AAPT.  College + Some Highschool.  Learning + Ideas and how to teach.  Hosted at Jefferson National PArticle Accelerator lab.  Presentation on particle physics.
	7 Students, present posters. 
	Research + PHysics class - Polarization project.  
	Brandon - EM waves and superpositions and absorbtion in a meta material.  Gap height and amplitude changes.  What's a metamaterial?  Man-made.  Exhibit non natrual material properies.  Optical - absorb a certain wavelength + freq of light.  Change the material to absorb more ore less.  Multilayers, em ring resonation layer, copper sheet. screw threads for aligbment to test absorions.  HOw taking measurements, recevier and a diode. broken port.  Microwaves, 2.8cm length, can easily work, visible light is small. need nano unti cels to measure absorbition. Generation? Transmitter. frequency vibration to generate wave. A kind of diode -> diode exchange. one receives and one emits.



- October 25: No Meeting, Dr. Bennett Physics, Taylor Alumni Weekend,.
 
 
Roadmap: Making progress towards running some new code.
 
Milestones:
 
- Build a Spacetime diagram or a Superhighway and build it in d3.  Considerations are Axes, Animations, and which objects are shown.
 
- Build a step-wise calculator in Javascript/Typescript that calculates t, x, and beta for the three trip to alpha clocks.  It's output should match the Spacetime Java csv output.
 
 
 

