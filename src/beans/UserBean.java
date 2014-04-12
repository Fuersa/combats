package beans;

public class UserBean {
	
    private String userId;
    private String Full_Name;
    private String Security_Answer;
    private String User_Pass;
    private String User_EMail;
    private String rank;
    private String Character_Birth_day;
    private String User_Birth_Day;
    private String User_Gender;
    private String User_City;
    private String SessionID;
    public boolean valid;
    
    private String curHealth;
    private String maxHealth;
	
    private String money;
	
    private String strength; 
    private String strengthTotal;
	
    private String dexterity;
    private String dexterity_total;
	
    private String accuracy;
    private String accuracy_total;
	
    private String endurance;
	
    private String intellect;
    private String maxIntellect;
    private String wisdome;
    private String maxWisdome;
    
    private String exp;
    private String nextExp;
    
    private String notUsedStats;
    private String currentTotalStat;
    private String nameOfTheStat;
	
    private String swordSkill;
    private String SpearSkill;
    private String maceSkill;
    private String axeSkill;
    private String daggerSkill;
    
    private String charImage;
	
    private String charLevel;
    
    private String buildingId;
    
    private String login;
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFull_Name() {
		return Full_Name;
	}
	public void setFull_Name(String full_Name) {
		Full_Name = full_Name;
	}
	public String getSecurity_Answer() {
		return Security_Answer;
	}
	public void setSecurity_Answer(String security_Answer) {
		Security_Answer = security_Answer;
	}
	public String getUser_Pass() {
		return User_Pass;
	}
	public void setUser_Pass(String user_Pass) {
		User_Pass = user_Pass;
	}
	public String getUser_EMail() {
		return User_EMail;
	}
	public void setUser_EMail(String user_EMail) {
		User_EMail = user_EMail;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getCharacter_Birth_day() {
		return Character_Birth_day;
	}
	public void setCharacter_Birth_day(String character_Birth_day) {
		Character_Birth_day = character_Birth_day;
	}
	public String getUser_Birth_Day() {
		return User_Birth_Day;
	}
	public void setUser_Birth_Day(String user_Birth_Day) {
		User_Birth_Day = user_Birth_Day;
	}
	public String getUser_Gender() {
		return User_Gender;
	}
	public void setUser_Gender(String user_Gender) {
		User_Gender = user_Gender;
	}
	public String getUser_City() {
		return User_City;
	}
	public void setUser_City(String user_City) {
		User_City = user_City;
	}
	public String getSessionID() {
		return SessionID;
	}
	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	//character stats
	
	public String getCurHealth() {
		return curHealth;
	}

	public void setCurHealth(String curHealth) {
		this.curHealth = curHealth;
	}

	public String getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(String maxHealth) {
		this.maxHealth = maxHealth;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getStrengthTotal() {
		return strengthTotal;
	}

	public void setStrengthTotal(String strengthTotal) {
		this.strengthTotal = strengthTotal;
	}

	public String getDexterity() {
		return dexterity;
	}

	public void setDexterity(String dexterity) {
		this.dexterity = dexterity;
	}

	public String getDexterity_total() {
		return dexterity_total;
	}

	public void setDexterity_total(String dexterity_total) {
		this.dexterity_total = dexterity_total;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getAccuracy_total() {
		return accuracy_total;
	}

	public void setAccuracy_total(String accuracy_total) {
		this.accuracy_total = accuracy_total;
	}

	public String getEndurance() {
		return endurance;
	}

	public void setEndurance(String endurance) {
		this.endurance = endurance;
	}

	public String getNotUsedStats() {
		return notUsedStats;
	}

	public void setNotUsedStats(String notUsedStats) {
		this.notUsedStats = notUsedStats;
	}

	public String getSwordSkill() {
		return swordSkill;
	}

	public void setSwordSkill(String swordSkill) {
		this.swordSkill = swordSkill;
	}

	public String getSpearSkill() {
		return SpearSkill;
	}

	public void setSpearSkill(String spearSkill) {
		SpearSkill = spearSkill;
	}

	public String getMaceSkill() {
		return maceSkill;
	}

	public void setMaceSkill(String maceSkill) {
		this.maceSkill = maceSkill;
	}

	public String getAxeSkill() {
		return axeSkill;
	}

	public void setAxeSkill(String axeSkill) {
		this.axeSkill = axeSkill;
	}

	public String getDaggerSkill() {
		return daggerSkill;
	}

	public void setDaggerSkill(String daggerSkill) {
		this.daggerSkill = daggerSkill;
	}

	public String getCharLevel() {
		return charLevel;
	}

	public void setCharLevel(String charLevel) {
		this.charLevel = charLevel;
	}
	public String getCharImage() {
		return charImage;
	}
	public void setCharImage(String character_Image) {
		charImage = character_Image;
	}
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public String getIntellect() {
		return intellect;
	}
	public void setIntellect(String intellect) {
		this.intellect = intellect;
	}
	public String getWisdome() {
		return wisdome;
	}
	public void setWisdome(String wisdome) {
		this.wisdome = wisdome;
	}
	public String getMaxIntellect() {
		return maxIntellect;
	}
	public void setMaxIntellect(String maxIntellect) {
		this.maxIntellect = maxIntellect;
	}
	public String getMaxWisdome() {
		return maxWisdome;
	}
	public void setMaxWisdome(String maxWisdome) {
		this.maxWisdome = maxWisdome;
	}
	public String getCurrentTotalStat() {
		return currentTotalStat;
	}
	public void setCurrentTotalStat(String currentTotalStat) {
		this.currentTotalStat = currentTotalStat;
	}
	public String getNameOfTheStat() {
		return nameOfTheStat;
	}
	public void setNameOfTheStat(String nameOfTheStat) {
		this.nameOfTheStat = nameOfTheStat;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getNextExp() {
		return nextExp;
	}
	public void setNextExp(String nextExp) {
		this.nextExp = nextExp;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
    
    
}