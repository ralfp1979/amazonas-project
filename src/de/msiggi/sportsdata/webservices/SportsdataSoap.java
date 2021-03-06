
package de.msiggi.sportsdata.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "SportsdataSoap", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SportsdataSoap {


    /**
     * Gibt eine Struktur aller verfuegbaren Ligen zurueck! Erwartet keine Parameter. Das Ergebnis dieser Abfrage unterliegt einem serverseitigen Cache von 600 Sekunden.
     * 
     * @return
     *     returns de.msiggi.sportsdata.webservices.ArrayOfLeague
     */
    @WebMethod(operationName = "GetAvailLeagues", action = "http://msiggi.de/Sportsdata/Webservices/GetAvailLeagues")
    @WebResult(name = "GetAvailLeaguesResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetAvailLeagues", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetAvailLeagues")
    @ResponseWrapper(localName = "GetAvailLeaguesResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetAvailLeaguesResponse")
    public ArrayOfLeague getAvailLeagues();

    /**
     * Gibt eine Struktur des naechsten anstehenden Spieles der als Parameter zu uebergebenen Liga zurueck.
     * 
     * @param leagueShortcut
     * @return
     *     returns de.msiggi.sportsdata.webservices.Matchdata
     */
    @WebMethod(operationName = "GetNextMatch", action = "http://msiggi.de/Sportsdata/Webservices/GetNextMatch")
    @WebResult(name = "GetNextMatchResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetNextMatch", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetNextMatch")
    @ResponseWrapper(localName = "GetNextMatchResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetNextMatchResponse")
    public Matchdata getNextMatch(
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut);

    /**
     * Gibt eine Struktur des zuletzt ausgetragenen Spieles der als Parameter zu uebergebenen Liga zurueck.
     * 
     * @param leagueShortcut
     * @return
     *     returns de.msiggi.sportsdata.webservices.Matchdata
     */
    @WebMethod(operationName = "GetLastMatch", action = "http://msiggi.de/Sportsdata/Webservices/GetLastMatch")
    @WebResult(name = "GetLastMatchResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetLastMatch", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetLastMatch")
    @ResponseWrapper(localName = "GetLastMatchResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetLastMatchResponse")
    public Matchdata getLastMatch(
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut);

    /**
     * Gibt eine Struktur des  naechsten anstehenden Spieles des als Parameter zu uebergebenen Teams der ebenfalls zu uebergebenen Liga zurueck.
     * 
     * @param leagueId
     * @param teamId
     * @return
     *     returns de.msiggi.sportsdata.webservices.Matchdata
     */
    @WebMethod(operationName = "GetNextMatchByLeagueTeam", action = "http://msiggi.de/Sportsdata/Webservices/GetNextMatchByLeagueTeam")
    @WebResult(name = "GetNextMatchByLeagueTeamResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetNextMatchByLeagueTeam", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetNextMatchByLeagueTeam")
    @ResponseWrapper(localName = "GetNextMatchByLeagueTeamResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetNextMatchByLeagueTeamResponse")
    public Matchdata getNextMatchByLeagueTeam(
        @WebParam(name = "leagueId", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int leagueId,
        @WebParam(name = "teamId", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int teamId);

    /**
     * Gibt eine Struktur des zuletzt ausgetragenen Spieles des als Parameter zu uebergebenen Teams der ebenfalls zu uebergebenen Liga zurueck.
     * 
     * @param leagueId
     * @param teamId
     * @return
     *     returns de.msiggi.sportsdata.webservices.Matchdata
     */
    @WebMethod(operationName = "GetLastMatchByLeagueTeam", action = "http://msiggi.de/Sportsdata/Webservices/GetLastMatchByLeagueTeam")
    @WebResult(name = "GetLastMatchByLeagueTeamResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetLastMatchByLeagueTeam", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetLastMatchByLeagueTeam")
    @ResponseWrapper(localName = "GetLastMatchByLeagueTeamResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetLastMatchByLeagueTeamResponse")
    public Matchdata getLastMatchByLeagueTeam(
        @WebParam(name = "leagueId", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int leagueId,
        @WebParam(name = "teamId", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int teamId);

    /**
     * Gibt die aktuelle groupOrderID (entspricht z.B. bei der Fussball-Bundesliga dem 'Spieltag') des als Parameter zu uebergebenen leagueShortcuts (z.B. 'bl1') aus. Der aktuelle Spieltag wird jeweils zur Haelfte der Zeit zwischen dem letzten Spiel des letzten Spieltages und dem ersten Spiel des naechsten Spieltages erhoeht.
     * 
     * @param leagueShortcut
     * @return
     *     returns int
     */
    @WebMethod(operationName = "GetCurrentGroupOrderID", action = "http://msiggi.de/Sportsdata/Webservices/GetCurrentGroupOrderID")
    @WebResult(name = "GetCurrentGroupOrderIDResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetCurrentGroupOrderID", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetCurrentGroupOrderID")
    @ResponseWrapper(localName = "GetCurrentGroupOrderIDResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetCurrentGroupOrderIDResponse")
    public int getCurrentGroupOrderID(
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut);

    /**
     * Gibt die aktuelle Group (entspricht z.B. bei der Fussball-Bundesliga dem 'Spieltag') des als Parameter zu uebergebenen leagueShortcuts (z.B. 'bl1') aus. Der aktuelle Spieltag wird jeweils zur Haelfte der Zeit zwischen dem letzten Spiel des letzten Spieltages und dem ersten Spiel des naechsten Spieltages erhoeht.
     * 
     * @param leagueShortcut
     * @return
     *     returns de.msiggi.sportsdata.webservices.Group
     */
    @WebMethod(operationName = "GetCurrentGroup", action = "http://msiggi.de/Sportsdata/Webservices/GetCurrentGroup")
    @WebResult(name = "GetCurrentGroupResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetCurrentGroup", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetCurrentGroup")
    @ResponseWrapper(localName = "GetCurrentGroupResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetCurrentGroupResponse")
    public Group getCurrentGroup(
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut);

    /**
     * Gibt eine Struktur von Sport-Spieldaten zurueck. Als Parameter werden eine groupOrderID (zu entnehmen aus GetAvailGroups, entspricht z.B. bei der Fussball-Bundesliga dem Spieltag), der Liga-Shortcut (z.B. 'bl1') sowie die Saison (aus GetAvailLeagues, z.B. '2009') erwartet. Das Ergebnis dieser Abfrage unterliegt einem serverseitigen Cache von 120 Sekunden.
     * 
     * @param groupOrderID
     * @param leagueShortcut
     * @param leagueSaison
     * @return
     *     returns de.msiggi.sportsdata.webservices.ArrayOfMatchdata
     */
    @WebMethod(operationName = "GetMatchdataByGroupLeagueSaison", action = "http://msiggi.de/Sportsdata/Webservices/GetMatchdataByGroupLeagueSaison")
    @WebResult(name = "GetMatchdataByGroupLeagueSaisonResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetMatchdataByGroupLeagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetMatchdataByGroupLeagueSaison")
    @ResponseWrapper(localName = "GetMatchdataByGroupLeagueSaisonResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetMatchdataByGroupLeagueSaisonResponse")
    public ArrayOfMatchdata getMatchdataByGroupLeagueSaison(
        @WebParam(name = "groupOrderID", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int groupOrderID,
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut,
        @WebParam(name = "leagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueSaison);

    /**
     * Gibt eine Struktur von Sport-Spieldaten zurueck. Die Beginn-Zeit der ausgegebenen Spieldaten liegt zwischen den als Parameter zu uebergebenen DateTime-Werten. (fromDateTime <= matchBeginDateTime < toDateTime)Als weiterer Parameter wird der Liga-Shortcut (z.B. 'bl1') erwartet.
     * 
     * @param toDateTime
     * @param leagueShortcut
     * @param fromDateTime
     * @return
     *     returns de.msiggi.sportsdata.webservices.ArrayOfMatchdata
     */
    @WebMethod(operationName = "GetMatchdataByLeagueDateTime", action = "http://msiggi.de/Sportsdata/Webservices/GetMatchdataByLeagueDateTime")
    @WebResult(name = "GetMatchdataByLeagueDateTimeResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetMatchdataByLeagueDateTime", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetMatchdataByLeagueDateTime")
    @ResponseWrapper(localName = "GetMatchdataByLeagueDateTimeResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetMatchdataByLeagueDateTimeResponse")
    public ArrayOfMatchdata getMatchdataByLeagueDateTime(
        @WebParam(name = "fromDateTime", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        XMLGregorianCalendar fromDateTime,
        @WebParam(name = "toDateTime", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        XMLGregorianCalendar toDateTime,
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut);

    /**
     * Gibt eine Struktur von Matches zurueck, bei welchen die als Parameter uebergebenen Teams gegeneinander spielten.
     * 
     * @param teamID1
     * @param teamID2
     * @return
     *     returns de.msiggi.sportsdata.webservices.ArrayOfMatchdata
     */
    @WebMethod(operationName = "GetMatchdataByTeams", action = "http://msiggi.de/Sportsdata/Webservices/GetMatchdataByTeams")
    @WebResult(name = "GetMatchdataByTeamsResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetMatchdataByTeams", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetMatchdataByTeams")
    @ResponseWrapper(localName = "GetMatchdataByTeamsResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetMatchdataByTeamsResponse")
    public ArrayOfMatchdata getMatchdataByTeams(
        @WebParam(name = "teamID1", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int teamID1,
        @WebParam(name = "teamID2", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int teamID2);

    /**
     * Gibt eine Struktur von Sport-Spieldaten aller Spiele der Liga pro Saison zurueck. Als Parameter werden der Liga-Shortcut (z.B. 'bl1') sowie die Saison (aus GetAvailLeagues, z.B. '2007') erwartet. Das Ergebnis dieser Abfrage unterliegt einem serverseitigen Cache von 300 Sekunden.
     * 
     * @param leagueShortcut
     * @param leagueSaison
     * @return
     *     returns de.msiggi.sportsdata.webservices.ArrayOfMatchdata
     */
    @WebMethod(operationName = "GetMatchdataByLeagueSaison", action = "http://msiggi.de/Sportsdata/Webservices/GetMatchdataByLeagueSaison")
    @WebResult(name = "GetMatchdataByLeagueSaisonResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetMatchdataByLeagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetMatchdataByLeagueSaison")
    @ResponseWrapper(localName = "GetMatchdataByLeagueSaisonResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetMatchdataByLeagueSaisonResponse")
    public ArrayOfMatchdata getMatchdataByLeagueSaison(
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut,
        @WebParam(name = "leagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueSaison);

    /**
     * Gibt einen serialisiertes JSON-Objekt von Sport-Spieldaten zurueck. Als Parameter werden eine groupOrderID (zu entnehmen aus GetAvailGroups, entspricht z.B. bei der Fussball-Bundesliga dem Spieltag), der Liga-Shortcut (z.B. 'bl1') sowie die Saison (aus GetAvailLeagues, z.B. '2009') erwartet. Das Ergebnis dieser Abfrage unterliegt einem serverseitigen Cache von 120 Sekunden.
     * 
     * @param groupOrderID
     * @param leagueShortcut
     * @param leagueSaison
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetMatchdataByGroupLeagueSaisonJSON", action = "http://msiggi.de/Sportsdata/Webservices/GetMatchdataByGroupLeagueSaisonJSON")
    @WebResult(name = "GetMatchdataByGroupLeagueSaisonJSONResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetMatchdataByGroupLeagueSaisonJSON", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetMatchdataByGroupLeagueSaisonJSON")
    @ResponseWrapper(localName = "GetMatchdataByGroupLeagueSaisonJSONResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetMatchdataByGroupLeagueSaisonJSONResponse")
    public String getMatchdataByGroupLeagueSaisonJSON(
        @WebParam(name = "groupOrderID", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int groupOrderID,
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut,
        @WebParam(name = "leagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueSaison);

    /**
     * Gibt eine Struktur deutscher Fussball-Spieldaten zurueck. Diese Methode steht nur noch aus Gruenden der Kompatibilitaet zu aelteren Applikationen zur Verfuegung. Bitte nutzen sie vorrangig die GetMatchdata... - Methoden!
     * 
     * @param userkennung
     * @param liga
     * @param spieltag
     * @param saison
     * @return
     *     returns de.msiggi.sportsdata.webservices.ArrayOfFussballdaten
     */
    @WebMethod(operationName = "GetFusballdaten", action = "http://msiggi.de/Sportsdata/Webservices/GetFusballdaten")
    @WebResult(name = "GetFusballdatenResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetFusballdaten", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetFusballdaten")
    @ResponseWrapper(localName = "GetFusballdatenResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetFusballdatenResponse")
    public ArrayOfFussballdaten getFusballdaten(
        @WebParam(name = "Spieltag", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int spieltag,
        @WebParam(name = "Liga", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String liga,
        @WebParam(name = "Saison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int saison,
        @WebParam(name = "Userkennung", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String userkennung);

    /**
     * Gibt eine Struktur des Spieles der als Parameter zu uebergebenen MatchID zurueck.
     * 
     * @param matchID
     * @return
     *     returns de.msiggi.sportsdata.webservices.Matchdata
     */
    @WebMethod(operationName = "GetMatchByMatchID", action = "http://msiggi.de/Sportsdata/Webservices/GetMatchByMatchID")
    @WebResult(name = "GetMatchByMatchIDResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetMatchByMatchID", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetMatchByMatchID")
    @ResponseWrapper(localName = "GetMatchByMatchIDResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetMatchByMatchIDResponse")
    public Matchdata getMatchByMatchID(
        @WebParam(name = "MatchID", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int matchID);

    /**
     * Gibt eine Liste aller Teams der als Parameter zu uebergebenen Liga + Saison zurueck.
     * 
     * @param leagueShortcut
     * @param leagueSaison
     * @return
     *     returns de.msiggi.sportsdata.webservices.ArrayOfTeam
     */
    @WebMethod(operationName = "GetTeamsByLeagueSaison", action = "http://msiggi.de/Sportsdata/Webservices/GetTeamsByLeagueSaison")
    @WebResult(name = "GetTeamsByLeagueSaisonResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetTeamsByLeagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetTeamsByLeagueSaison")
    @ResponseWrapper(localName = "GetTeamsByLeagueSaisonResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetTeamsByLeagueSaisonResponse")
    public ArrayOfTeam getTeamsByLeagueSaison(
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut,
        @WebParam(name = "leagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueSaison);

    /**
     * Gibt eine Liste der bereits eingetragenen Spiel-Einteilungen (Spieltag, Vorrunde, Finale, ...) der als Parameter zu uebergebenen Liga + Saison zurueck.
     * 
     * @param leagueShortcut
     * @param leagueSaison
     * @return
     *     returns de.msiggi.sportsdata.webservices.ArrayOfGroup
     */
    @WebMethod(operationName = "GetAvailGroups", action = "http://msiggi.de/Sportsdata/Webservices/GetAvailGroups")
    @WebResult(name = "GetAvailGroupsResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetAvailGroups", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetAvailGroups")
    @ResponseWrapper(localName = "GetAvailGroupsResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetAvailGroupsResponse")
    public ArrayOfGroup getAvailGroups(
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut,
        @WebParam(name = "leagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueSaison);

    /**
     * Gibt eine Liste der verfuegbaren Sportarten, fuer welche gueltige Ligen bestehen, zurueck. Erwartet keine Parameter
     * 
     * @return
     *     returns de.msiggi.sportsdata.webservices.ArrayOfSport
     */
    @WebMethod(operationName = "GetAvailSports", action = "http://msiggi.de/Sportsdata/Webservices/GetAvailSports")
    @WebResult(name = "GetAvailSportsResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetAvailSports", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetAvailSports")
    @ResponseWrapper(localName = "GetAvailSportsResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetAvailSportsResponse")
    public ArrayOfSport getAvailSports();

    /**
     * Gibt eine Struktur aller verfuegbaren Ligen fuer die zu uebergebende SportID zurueck. Diese ist aus 'GetAvailSports()' zu entnehmen!
     * 
     * @param sportID
     * @return
     *     returns de.msiggi.sportsdata.webservices.ArrayOfLeague
     */
    @WebMethod(operationName = "GetAvailLeaguesBySports", action = "http://msiggi.de/Sportsdata/Webservices/GetAvailLeaguesBySports")
    @WebResult(name = "GetAvailLeaguesBySportsResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetAvailLeaguesBySports", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetAvailLeaguesBySports")
    @ResponseWrapper(localName = "GetAvailLeaguesBySportsResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetAvailLeaguesBySportsResponse")
    public ArrayOfLeague getAvailLeaguesBySports(
        @WebParam(name = "sportID", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int sportID);

    /**
     * Gibt eine Liste aller Goals des als Parameter zu uebergebenen Match zurueck.
     * 
     * @param matchID
     * @return
     *     returns de.msiggi.sportsdata.webservices.ArrayOfGoal
     */
    @WebMethod(operationName = "GetGoalsByMatch", action = "http://msiggi.de/Sportsdata/Webservices/GetGoalsByMatch")
    @WebResult(name = "GetGoalsByMatchResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetGoalsByMatch", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetGoalsByMatch")
    @ResponseWrapper(localName = "GetGoalsByMatchResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetGoalsByMatchResponse")
    public ArrayOfGoal getGoalsByMatch(
        @WebParam(name = "MatchID", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int matchID);

    /**
     * Gibt eine Liste aller Goals der als Parameter zu uebergebenen Liga + Saison zurueck.
     * 
     * @param leagueShortcut
     * @param leagueSaison
     * @return
     *     returns de.msiggi.sportsdata.webservices.ArrayOfGoal
     */
    @WebMethod(operationName = "GetGoalsByLeagueSaison", action = "http://msiggi.de/Sportsdata/Webservices/GetGoalsByLeagueSaison")
    @WebResult(name = "GetGoalsByLeagueSaisonResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetGoalsByLeagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetGoalsByLeagueSaison")
    @ResponseWrapper(localName = "GetGoalsByLeagueSaisonResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetGoalsByLeagueSaisonResponse")
    public ArrayOfGoal getGoalsByLeagueSaison(
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut,
        @WebParam(name = "leagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueSaison);

    /**
     * Gibt eine Liste der GoalGetter der als Parameter zu uebergebenen Liga + Saison zurueck.
     * 
     * @param leagueShortcut
     * @param leagueSaison
     * @return
     *     returns de.msiggi.sportsdata.webservices.ArrayOfGoalGetter
     */
    @WebMethod(operationName = "GetGoalGettersByLeagueSaison", action = "http://msiggi.de/Sportsdata/Webservices/GetGoalGettersByLeagueSaison")
    @WebResult(name = "GetGoalGettersByLeagueSaisonResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetGoalGettersByLeagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetGoalGettersByLeagueSaison")
    @ResponseWrapper(localName = "GetGoalGettersByLeagueSaisonResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetGoalGettersByLeagueSaisonResponse")
    public ArrayOfGoalGetter getGoalGettersByLeagueSaison(
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut,
        @WebParam(name = "leagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueSaison);

    /**
     * Gibt das Datum der letzten Aenderung in der als Parameter zu uebergebenen Liga + Saison zurueck. Kann verwendet werden, um clientseitg unnoetige Abfragen zu vermeiden (Cache)
     * 
     * @param leagueShortcut
     * @param leagueSaison
     * @return
     *     returns javax.xml.datatype.XMLGregorianCalendar
     */
    @WebMethod(operationName = "GetLastChangeDateByLeagueSaison", action = "http://msiggi.de/Sportsdata/Webservices/GetLastChangeDateByLeagueSaison")
    @WebResult(name = "GetLastChangeDateByLeagueSaisonResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetLastChangeDateByLeagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetLastChangeDateByLeagueSaison")
    @ResponseWrapper(localName = "GetLastChangeDateByLeagueSaisonResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetLastChangeDateByLeagueSaisonResponse")
    public XMLGregorianCalendar getLastChangeDateByLeagueSaison(
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut,
        @WebParam(name = "leagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueSaison);

    /**
     * Gibt das Datum der letzten Aenderung in der als Parameter zu uebergebenen Liga + Saison zurueck. Kann verwendet werden, um clientseitg unnoetige Abfragen zu vermeiden (Cache)
     * 
     * @param groupOrderID
     * @param leagueShortcut
     * @param leagueSaison
     * @return
     *     returns javax.xml.datatype.XMLGregorianCalendar
     */
    @WebMethod(operationName = "GetLastChangeDateByGroupLeagueSaison", action = "http://msiggi.de/Sportsdata/Webservices/GetLastChangeDateByGroupLeagueSaison")
    @WebResult(name = "GetLastChangeDateByGroupLeagueSaisonResult", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
    @RequestWrapper(localName = "GetLastChangeDateByGroupLeagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetLastChangeDateByGroupLeagueSaison")
    @ResponseWrapper(localName = "GetLastChangeDateByGroupLeagueSaisonResponse", targetNamespace = "http://msiggi.de/Sportsdata/Webservices", className = "de.msiggi.sportsdata.webservices.GetLastChangeDateByGroupLeagueSaisonResponse")
    public XMLGregorianCalendar getLastChangeDateByGroupLeagueSaison(
        @WebParam(name = "groupOrderID", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        int groupOrderID,
        @WebParam(name = "leagueShortcut", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueShortcut,
        @WebParam(name = "leagueSaison", targetNamespace = "http://msiggi.de/Sportsdata/Webservices")
        String leagueSaison);

}
