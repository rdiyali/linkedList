public class linkListFreq {
	private char letter;
	private int frequency;
	
	public linkListFreq(char c) {
		this.letter = c;
		this.frequency = 0; 
		
	}
	
	public char getCharacter() {
		return letter;
	}
	
	public void setCharacter(char c) {
		this.letter = c;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void setFrequency(int f) {
		this.frequency = f;
	}
	
	public void increment() {
		frequency++;
	}
	

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        linkListFreq other = (linkListFreq) obj;
        return this.letter == other.letter; 
    }
    
    @Override
    public String toString() {
        String output =  this.letter + "(" + (int)this.letter + ") " + this.frequency;
        return output;
    }
}

