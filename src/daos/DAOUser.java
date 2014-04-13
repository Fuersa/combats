package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import manager.ConnectionManager;
import beans.ItemBean;
import beans.RoomBean;
import beans.UserBean;

public class DAOUser {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static int rs2;

	public static UserBean login(UserBean user) {
		System.out
				.println("	(DAOUser.java [login-Method]):     *** START SERVLET [--DAOUser.java--] ==>(METHOD)=> [--login--]  ***");

		// preparing some objects for connection
		Statement stmt = null;

		System.out
				.println("	(DAOUser.java [login-Method]):     SETTING userLogin and password from UserBean user ,parsed to this DAO");
		String userLogin = user.getLogin();
		String password = user.getUser_Pass();

		System.out
				.println("	(DAOUser.java [login-Method]):     START -- creation search query");
		// Create query for searching USER in DB, to control if USER exists
		String searchQuery = "select * from users where Nick_Name='"
				+ userLogin + "' AND User_Pass='" + password + "'";
		System.out
				.println("	(DAOUser.java [login-Method]):     SearchQuery created: "
						+ searchQuery);
		System.out
				.println("	(DAOUser.java [login-Method]):     USER CHECK: userLogin, Password");
		System.out
				.println("	(DAOUser.java [login-Method]):     Your user name is "
						+ userLogin);
		System.out
				.println("	(DAOUser.java [login-Method]):     Your password is "
						+ password);
		System.out
				.println("	(DAOUser.java [login-Method]):     END USER CHECK: userLogin, Password ***");

		// Starting connection manager
		System.out
				.println("	(DAOUser.java [login-Method]):     Start TRY-BLOCK to CONNECTION to the database");
		try {

			// connect to DB
			System.out.println("	(DAOUser.java [login-Method]):     getConnection");
			currentCon = ConnectionManager.getConnection();
			System.out.println("	(DAOUser.java [login-Method]):     statement getting the value currentCon.createStatement");
			stmt = currentCon.createStatement();
			System.out.println("	(DAOUser.java [login-Method]):     START QUERY EXECUTION");
			rs = stmt.executeQuery(searchQuery);
			System.out.println("	(DAOUser.java [login-Method]):     Query EXECUTED");
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			System.out.println("	(DAOUser.java [login-Method]):     Start if-BLOCK to check !more");
			if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				user.setValid(false);
			}

			// if user exists set the isValid variable to true
			else if (more) {
				System.out.println("	(DAOUser.java [login-Method]):     User exists so here starts ELSE IF");
				System.out.println("	(DAOUser.java [login-Method]):     START - GET Login, Id, Email, Firstname, Lastname, Rank.");

				// Personal Information about the user
				String id = rs.getString("USER_ID");
				String login = rs.getString("Nick_Name");
				String email = rs.getString("User_EMail");
				String sec_answer = rs.getString("Security_Answer");
				String name = rs.getString("Full_Name");
				String birthday = rs.getString("User_Birth_Day");
				String char_birthday = rs.getString("Character_Birth_Day");
				String gender = rs.getString("User_Gender");
				String city = rs.getString("User_City");
				String buildingId = rs.getString("Building");

				System.out
						.println("	(DAOUser.java [login-Method]):     Welcome ");
				System.out.println("	(DAOUser.java [login-Method]):     // "
						+ id + " // " + login + "// " + email + "// "
						+ sec_answer);
				System.out.println("	(DAOUser.java [login-Method]):     // "
						+ name + "// " + birthday + "// " + char_birthday
						+ "// " + gender);
				System.out.println("	(DAOUser.java [login-Method]):     // "
						+ city);
				System.out
						.println("	(DAOUser.java [login-Method]):     ////BUIDLING ID: "
								+ buildingId);
				System.out
						.println("	(DAOUser.java [login-Method]):     END - getting the details of the rs");

				// Set attributes to BEAN user
				System.out
						.println("	(DAOUser.java [login-Method]):     Setting attributes to the USER");
				user.setUserId(id);
				user.setLogin(login);
				user.setUser_EMail(email);
				user.setSecurity_Answer(sec_answer);
				user.setFull_Name(name);
				user.setUser_Birth_Day(birthday);
				user.setCharacter_Birth_day(char_birthday);
				user.setUser_Gender(gender);
				user.setUser_City(city);
				user.setBuildingId(buildingId);
				user.setValid(true);

				System.out
						.println("	(DAOUser.java [login-Method]):     END SETTING -- bean attributes.");
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
		System.out
				.println("	(DAOUser.java [login-Method]):     *** END SERVLET [--DAOUser.java--] ==>(METHOD)=> [--login--]  *** ");
		System.out
				.println("	(DAOUser.java [login-Method]):     DAO RETURN - RETURN user: "
						+ user);
		return user;

	}

	public static UserBean getDetails(UserBean user) {
		System.out.println("	(DAOUser.java [getDetails-Method]):     *** START SERVLET [--DAOUser.java--] ==>(METHOD)=> [--getDetails--]  ***");

		// preparing some objects for connection
		Statement stmt = null;

		String userLogin = user.getLogin();
		String id = user.getUserId();

		System.out
				.println("	(DAOUser.java [getDetails-Method]):     START -- creation search query");

		// Create query for searching USER in DB, to control if USER exists
		String searchQuery = "select * from users where Nick_Name='"
				+ userLogin + "' AND User_id='" + id + "'";

		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out
				.println("	(DAOUser.java [getDetails-Method]):     USER CHECK: userLogin, Password");
		System.out
				.println("	(DAOUser.java [getDetails-Method]):     Your user name is "
						+ userLogin);
		System.out
				.println("	(DAOUser.java [getDetails-Method]):     Your id is "
						+ id);
		System.out.println("	(DAOUser.java [getDetails-Method]):     Query: "
				+ searchQuery);
		System.out
				.println("	(DAOUser.java [getDetails-Method]):     END USER CHECK: userLogin, id ***");

		// Starting connection manager
		try {

			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			System.out
					.println("	(DAOUser.java [getDetails-Method]):     QUERY EXECUTION");
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out
						.println("Sorry, you are not a registered user! Please sign up first");
				user.setValid(false);
			}

			// if user exists set the isValid variable to true
			else if (more) {
				System.out
						.println("	(DAOUser.java [getDetails-Method]):     START - GET Login, Id, Email, Firstname, Lastname, Rank.");

				// Getting the details from rs
				System.out
						.println("	(DAOUser.java [getDetails-Method]):     GETTING DETAILS FROM RS");
				String user_id = rs.getString("USER_ID");
				String login = rs.getString("Nick_Name");
				String email = rs.getString("User_EMail");
				String sec_answer = rs.getString("Security_Answer");
				String name = rs.getString("Full_Name");
				String birthday = rs.getString("User_Birth_Day");
				String char_birthday = rs.getString("Character_Birth_Day");
				String gender = rs.getString("User_Gender");
				String city = rs.getString("User_City");

				// Stats of the character
				String lvl = rs.getString("Character_Level");
				String str = rs.getString("Character_strength");
				String maxStr = rs.getString("Character_Strength_Total");

				String endu = rs.getString("Character_Endurance");

				String accuracy = rs.getString("Character_Accuracy");
				String maxAccuracy = rs.getString("Character_Accuracy_Total");

				String dex = rs.getString("Character_Dexterity");
				String maxDex = rs.getString("Character_Dexterity_Total");

				String notUsedStats = rs.getString("Character_UnUsed_Points");

				String intellect = rs.getString("Character_Intellect");
				String maxIntellect = rs.getString("Character_IntellectTotal");

				String wisdome = rs.getString("Character_Wisdome");
				String maxWisdome = rs.getString("Character_WisdomeTotal");
				
				String exp = rs.getString("Character_experience");
				String nextExp = rs.getString("Character_NextExperience");
				
				// Finance of the user
				String money = rs.getString("Character_Money");

				// Image
				String image = rs.getString("Character_Image");

				// health
				String currentHealth = rs.getString("Character_CurHealth");
				String maxHealth = rs.getString("Character_MaxHealth");

				String buildingId = rs.getString("Building");

				System.out
						.println("	(DAOUser.java [getDetails-Method]):     DETAILS SETTED ");
				System.out
						.println("	(DAOUser.java [getDetails-Method]):     // "
								+ user_id + " // " + login + "// " + email
								+ "// " + sec_answer);
				System.out
						.println("	(DAOUser.java [getDetails-Method]):     // "
								+ name + "// " + birthday + "// "
								+ char_birthday + "// " + gender);
				System.out
						.println("	(DAOUser.java [getDetails-Method]):     // "
								+ city);

				// Set attributes to BEAN user
				System.out
						.println("	(DAOUser.java [getDetails-Method]):     Setting attributes to BEAN of USER");
				user.setUserId(user_id);
				user.setLogin(login);
				user.setUser_EMail(email);
				user.setSecurity_Answer(sec_answer);
				user.setFull_Name(name);
				user.setUser_Birth_Day(birthday);
				user.setCharacter_Birth_day(char_birthday);
				user.setUser_Gender(gender);
				user.setUser_City(city);
				user.setValid(true);

				user.setCharLevel(lvl);

				user.setStrength(str);
				user.setStrengthTotal(maxStr);
				user.setEndurance(endu);
				user.setAccuracy(accuracy);
				user.setAccuracy_total(maxAccuracy);
				user.setDexterity(dex);
				user.setDexterity_total(maxDex);
				user.setNotUsedStats(notUsedStats);
				
				user.setExp(exp);
				user.setNextExp(nextExp);

				// mage stats
				user.setIntellect(intellect);
				user.setMaxIntellect(maxIntellect);
				user.setWisdome(wisdome);
				user.setMaxWisdome(maxWisdome);

				user.setMoney(money);
				user.setCharImage(image);

				user.setCurHealth(currentHealth);
				user.setMaxHealth(maxHealth);

				user.setBuildingId(buildingId);

				System.out
						.println("	(DAOUser.java [getDetails-Method]):     END SETTING -- bean attributes.");
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
		System.out
				.println("	(DAOUser.java [getDetails-Method]):     *** END SERVLET [--DAOUser.java--] ==>(METHOD)=> [--getDetails--]  ***|||||||||");

		return user;

	}

	public static RoomBean getRoomDetails(RoomBean user) {
		System.out
				.println("	(DAOUser.java [getRoomDetails-Method]):     *** START SERVLET [--DAOUser.java--] ==>(METHOD)=> [--getRoomDetails--]  ***|||||||||");

		// preparing some objects for connection
		Statement stmt = null;

		String userLogin = user.getUserLogin();
		String buildingId = user.getBuilding_id();

		System.out
				.println("	(DAOUser.java [getRoomDetails-Method]):     START -- creation search query");

		// Create query for searching USER in DB, to control if USER exists

		// Get the Name and ID of the building where the user is located right
		// now
		String searchQuery = "SELECT b.BuildingName, u.Building FROM users u inner join Buildings b on b.id = u.Building WHERE Nick_Name='"
				+ userLogin + "'";

		// //Count the users in that location
		// String searchQueryCount =
		// "SELECT count(USER_ID) as CountUsers from users where Building = '"+
		// buildingId +"'";
		//
		// //Get the list of the users
		// String searchQueryUsersInRoom =
		// "SELECT Nick_Name,Character_Level from users where Building = 1";

		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out
				.println("	(DAOUser.java [getRoomDetails-Method]):     UserDetails about the room: "
						+ searchQuery);
		// System.out.println("Count users in room: " + searchQueryCount);
		// System.out.println("Users in the room: " + searchQueryUsersInRoom);

		// Starting connection manager
		try {

			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			System.out
					.println("	(DAOUser.java [getRoomDetails-Method]):     QUERY EXECUTION");
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out
						.println("Sorry, you are not a registered user! Please sign up first");
			}

			// if user exists set the isValid variable to true
			else if (more) {
				System.out
						.println("	(DAOUser.java [getRoomDetails-Method]):     START - Get BuildingName and ID");

				String buildingName = rs.getString("BuildingName");

				// Set attributes to BEAN user
				user.setRoom_name(buildingName);
				user.setBuilding_id(buildingId);

				System.out
						.println("	(DAOUser.java [getRoomDetails-Method]):     END SETTING -- bean attributes.");
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
		System.out
				.println("	(DAOUser.java [getRoomDetails-Method]):     *** END SERVLET [--DAOUser.java--] ==>(METHOD)=> [--getRoomDetails--]  ***|||||||||");

		return user;

	}

	public static RoomBean getRoomCount(RoomBean user) {
		System.out
				.println("	(DAOUser.java [getRoomCount-Method]):     *** START SERVLET [--DAOUser.java--] ==>(METHOD)=> [--getRoomCount--]  ***|||||||||");

		// preparing some objects for connection
		Statement stmt = null;

		String buildingId = user.getBuilding_id();

		System.out
				.println("	(DAOUser.java [getRoomCount-Method]):     START -- creation search query");

		// Create query for searching USER in DB, to control if USER exists

		// //Count the users in that location
		String searchQueryCount = "SELECT count(USER_ID) as CountUsers from users where Building = '"
				+ buildingId + "'";
		System.out.println("	(DAOUser.java [getRoomCount-Method]):     query: "
				+ searchQueryCount);
		//
		// //Get the list of the users
		// String searchQueryUsersInRoom =
		// "SELECT Nick_Name,Character_Level from users where Building = 1";

		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out
				.println("	(DAOUser.java [getRoomCount-Method]):     UserDetails about the room: "
						+ searchQueryCount);
		// System.out.println("Count users in room: " + searchQueryCount);
		// System.out.println("Users in the room: " + searchQueryUsersInRoom);

		// Starting connection manager
		try {

			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			System.out
					.println("	(DAOUser.java [getRoomCount-Method]):     QUERY EXECUTION");
			rs = stmt.executeQuery(searchQueryCount);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out
						.println("Sorry, you are not a registered user! Please sign up first");
			}

			// if user exists set the isValid variable to true
			else if (more) {
				String count = rs.getString("countusers");

				// Set attributes to BEAN user
				user.setCount(count);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
		System.out.println("	(DAOUser.java [getRoomCount-Method]):     *** END SERVLET [--DAOUser.java--] ==>(METHOD)=> [--getRoomDetails--]  ***|||||||||");

		return user;

	}

	public static Map getPlayersInCurrentRoom(RoomBean user) {
		System.out.println("	(DAOUser.java [getPlayersInCurrentRoom-Method]):     *** START SERVLET [--DAOUser.java--] ==>(METHOD)=> [--getRoomCount--]  ***|||||||||");

		Map<String, String> m1 = new HashMap<String, String>();

		// preparing some objects for connection
		Statement stmt = null;
		String buildingId = user.getBuilding_id();

		// Get the list of the users
		String searchQueryPlayersInRoom = "SELECT Nick_Name,Character_Level from users where Building = "
				+ buildingId;

		System.out.println("	(DAOUser.java [getPlayersInCurrentRoom-Method]):     UserDetails about the room: "
						+ searchQueryPlayersInRoom);

		// Starting connection manager
		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			System.out
					.println("	(DAOUser.java [getPlayersInCurrentRoom-Method]):     QUERY EXECUTION");
			rs = stmt.executeQuery(searchQueryPlayersInRoom);

			// if user does not exist set the isValid variable to false

			// if user exists set the isValid variable to true
			System.out
					.println("	(DAOUser.java [getPlayersInCurrentRoom-Method]):     Start DAO USERS GET PPL IN THE ROOM ******************");

			while (rs.next()) {
				UserBean player = new UserBean();

				player.setLogin(rs.getString("Nick_Name"));
				m1.put(rs.getString("Nick_Name"),
						rs.getString("Character_Level"));

			}

			System.out
					.println("	(DAOUser.java [getPlayersInCurrentRoom-Method]):     MAP: "
							+ m1);
			return m1;
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
		System.out
				.println("	(DAOUser.java [getPlayersInCurrentRoom-Method]):     *** END SERVLET [--DAOUser.java--] ==>(METHOD)=> [--getRoomDetails--]  ***|||||||||");

		return m1;

	}

	public static void addStat(UserBean user) {
		System.out.println("	(DAOUser.java [addStat-Method]):     *** START SERVLET [--DAOUser.java--] ==>(METHOD)=> [--login--]  ***");

		// preparing some objects for connection

		System.out.println("	(DAOUser.java [addStat-Method]):     SETTING  UserBean parsed to this DAO");
		String login = user.getLogin();
		int currentTotalStat = Integer.parseInt(user.getCurrentTotalStat());
		String nameOfTheStat = user.getNameOfTheStat();
		int notUsedStats = Integer.parseInt(user.getNotUsedStats());

		System.out.println("	(DAOUser.java [addStat-Method]):     START -- creation search query");
		// Create query for searching USER in DB, to control if USER exists

		String addStatQuery;
		if (notUsedStats > 0) {
			switch (nameOfTheStat) {
			case "str":
				currentTotalStat++;
				notUsedStats--;
				addStatQuery = "UPDATE Users SET Character_Strength=" + currentTotalStat + ",Character_UnUsed_Points=" + notUsedStats + " WHERE Nick_Name='" + login + "'";
				updateQuery(addStatQuery);
				break;
			case "dex":
				currentTotalStat++;
				notUsedStats--;
				addStatQuery = "UPDATE Users SET Character_Dexterity=" + currentTotalStat + ",Character_UnUsed_Points=" + notUsedStats + " WHERE Nick_Name='" + login + "'";
				updateQuery(addStatQuery);

				break;

			case "acc":
				currentTotalStat++;
				notUsedStats--;
				addStatQuery = "UPDATE Users SET Character_Accuracy=" + currentTotalStat + ",Character_UnUsed_Points=" + notUsedStats + " WHERE Nick_Name='" + login + "'";
				updateQuery(addStatQuery);

				break;
			case "endu":
				currentTotalStat++;
				notUsedStats--;
				addStatQuery = "UPDATE Users SET Character_Endurance=" + currentTotalStat + ",Character_UnUsed_Points=" + notUsedStats + " WHERE Nick_Name='" + login + "'";
				updateQuery(addStatQuery);

				break;
			case "intellect":
				currentTotalStat++;
				notUsedStats--;
				addStatQuery = "UPDATE Users SET Character_Intellect=" + currentTotalStat + ",Character_UnUsed_Points=" + notUsedStats + " WHERE Nick_Name='" + login + "'";
				updateQuery(addStatQuery);

				break;
			case "wisdome":
				currentTotalStat++;
				notUsedStats--;
				addStatQuery = "UPDATE Users SET Character_Wisdome=" + currentTotalStat + ",Character_UnUsed_Points=" + notUsedStats + " WHERE Nick_Name='" + login + "'";
				updateQuery(addStatQuery);

				break;
			default:
				break;
			}
			
			
			System.out.println("	(DAOUser.java [getPlayersInCurrentRoom-Method]):     *** END SERVLET [--DAOUser.java--] ==>(METHOD)=> [--getRoomDetails--]  ***|||||||||");


		}

	}
	
	public static Map<String, ItemBean> getAllItemsOfThePlayer(UserBean user) {
		System.out.println("	(DAOUser.java [getAllItemsOfThePlayer-Method]):     *** START SERVLET [--DAOUser.java--] ==>(METHOD)=> [--getRoomCount--]  ***|||||||||");

		Map<String, ItemBean> m1 = new HashMap<String, ItemBean>();

		// preparing some objects for connection
		Statement stmt = null;
		String login = user.getLogin();
		String userId = user.getUserId();
		
		// Get the list of the users
		String searchQueryAllItemsInInventory = "SELECT i.IT_ID, i.Item_Position, il.ItemType, il.ItemNo, il.Item_Image, il.ItemName FROM Items i inner join Items_List il on il.il_id=i.il_id WHERE Item_Owner='"+userId+"' and Item_Position='2'";
		
		

		System.out.println("	(DAOUser.java [getAllItemsOfThePlayer-Method]):     UserDetails about the room: " + searchQueryAllItemsInInventory);

		// Starting connection manager
		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			System.out.println("	(DAOUser.java [getAllItemsOfThePlayer-Method]):     QUERY EXECUTION");
			rs = stmt.executeQuery(searchQueryAllItemsInInventory);

			// if user does not exist set the isValid variable to false

			// if user exists set the isValid variable to true
			System.out.println("	(DAOUser.java [getAllItemsOfThePlayer-Method]):     Start DAO USERS GET PPL IN THE ROOM ******************");

			while (rs.next()) {

				ItemBean item = new ItemBean();
				
				item.setaItemImage(rs.getString("Item_Image"));
				item.setaItemName(rs.getString("ItemName"));
				item.setaItemNo(rs.getString("ItemNo"));
				item.setaItemType(rs.getString("ItemType"));
				item.setaSlotItemID( rs.getString("IT_ID"));
				
				m1.put(rs.getString("IT_ID"), item);
						
			}

			System.out.println("	(DAOUser.java [getAllItemsOfThePlayer-Method]):     MAP: " + m1);
			return m1;
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
		System.out.println("	(DAOUser.java [getAllItemsOfThePlayer-Method]):     *** END SERVLET [--DAOUser.java--] ==>(METHOD)=> [--getRoomDetails--]  ***|||||||||");

		return m1;

	}

	
	public static void updateQuery(String query) {
		System.out.println("Start EXECUTE QUERY - METHOD - in DAOUser");
		Statement stmt = null;
		
		try {
			// connect to DB
			System.out.println("ONE");
			currentCon = ConnectionManager.getConnection();
			System.out.println("TWO");
			stmt = currentCon.createStatement();
			System.out.println("THREE");
			System.out.println(query);
			rs2 = stmt.executeUpdate(query);
		}

		catch (Exception ex) { System.out.println(ex);}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
		
	}
}