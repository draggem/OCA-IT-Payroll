package oca.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



/**
 * Main class that creates all employees and specifies their managers
 */
public class OCAProject {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Person> person = new ArrayList();
        ArrayList<ISubordinate> jamesSubordinates, billSubordinates, johnNSubordinates, ashleySubordinates, christineSubordinates, amandaSubordinates, kateSubordinates, scarletSubordinates, juliaSubordinates, michaelSubordinates, victoriaSubordinates,charlotteSubordinates;
        jamesSubordinates = new ArrayList();
        billSubordinates = new ArrayList();
        johnNSubordinates = new ArrayList();
        ashleySubordinates = new ArrayList();
        christineSubordinates = new ArrayList();
        amandaSubordinates = new ArrayList();
        kateSubordinates = new ArrayList();
        scarletSubordinates = new ArrayList();
        juliaSubordinates = new ArrayList();
        michaelSubordinates = new ArrayList();
        victoriaSubordinates = new ArrayList();
        charlotteSubordinates = new ArrayList();
        
        
        /**
         * Instantiate Subordinates 
         * */
        CEO JamesMint = new CEO(jamesSubordinates);
        AdministrationManager BillJohns = new AdministrationManager(100000.00, JamesMint, billSubordinates);
        BranchManager KateHudson = new BranchManager(90000.00, BillJohns, kateSubordinates);
        BranchManager ScarletGreen = new BranchManager(90000.00, BillJohns, scarletSubordinates);
        BranchManager AmandaGreen = new BranchManager(90000.00, BillJohns, amandaSubordinates);
        FinancialAdministrator EricWhite = new FinancialAdministrator(75000.00, JamesMint);
        HROfficer JuliaSmith = new HROfficer(50000.00, JamesMint, juliaSubordinates);
        ProjectManager VictoriaBell = new ProjectManager(80000, AmandaGreen, victoriaSubordinates);
        ProjectManager CharlotteHond = new ProjectManager(80000, KateHudson, charlotteSubordinates);
        ProjectManager ChristineBennet = new ProjectManager(80000, AmandaGreen, christineSubordinates);
        SalesManager MichaelBrown = new SalesManager(75000.00, JamesMint, michaelSubordinates);
        Receptionist PeterGordon = new Receptionist(35000.00, MichaelBrown);
        SalesConsultant HelenChan = new SalesConsultant(27.50, MichaelBrown);
        SeniorProgramDeveloper JohnNorton = new SeniorProgramDeveloper(75000,VictoriaBell, johnNSubordinates);
        SeniorProgramDeveloper AshleySimpson = new SeniorProgramDeveloper(75000,VictoriaBell, ashleySubordinates);
        SystemAdministrator AndrewBlack = new SystemAdministrator(65000,AmandaGreen);
        SystemAdministrator JoanneDowman = new SystemAdministrator(65000,KateHudson);
        SystemAdministrator MichaelPerry = new SystemAdministrator(65000,ScarletGreen);
        SystemAnalyst AndrewBlank = new SystemAnalyst(75000,VictoriaBell);
        SystemAnalyst CarolWhite = new SystemAnalyst(75000,CharlotteHond);
        SystemAnalyst BradTurner = new SystemAnalyst(75000, ChristineBennet);
        Tester JamesCarol = new Tester(25.00, VictoriaBell);
        Tester ElenaTang = new Tester(25.00, CharlotteHond);
        Tester TessaGreen = new Tester(25.00, CharlotteHond);
        Tester DavidChand = new Tester(25.00, ChristineBennet);
        ProgramDeveloper AlexDillion = new ProgramDeveloper(70000.00, JohnNorton);
        ProgramDeveloper AndrewSampson = new ProgramDeveloper(70000.00, AshleySimpson);
        ProgramDeveloper DavidGalloway = new ProgramDeveloper(70000.00, ChristineBennet);
        
        
        
        
        //James Mint
        JamesMint.setfName("James");
        JamesMint.setlName("Mint");
        JamesMint.setDOB(formatter.parse("28/12/1977"));
        JamesMint.setStartOfWorkDate(formatter.parse("10/01/2010"));
        JamesMint.setTimePeriod(TimePeriods.MONTHLY);
        
        
        jamesSubordinates.add(BillJohns);
        jamesSubordinates.add(EricWhite);
        jamesSubordinates.add(JuliaSmith);
        jamesSubordinates.add(MichaelBrown);
        
        

        //BillJohns
        BillJohns.setfName("Bill");
        BillJohns.setlName("Johns");
        BillJohns.setDOB(formatter.parse("4/13/1981"));
        BillJohns.setStartOfWorkDate(formatter.parse("5/10/2012"));
        BillJohns.setIsContractor(false);
        BillJohns.setTimePeriod(TimePeriods.MONTHLY);
        
        billSubordinates.add(KateHudson);
        billSubordinates.add(ScarletGreen);
        billSubordinates.add(AmandaGreen);
        
        
        
        //Kate Hudson
        KateHudson.setfName("Kate");
        KateHudson.setlName("Hudson");
        KateHudson.setDOB(formatter.parse("13/07/1981"));
        KateHudson.setStartOfWorkDate(formatter.parse("3/11/2013"));
        KateHudson.setIsContractor(false);
        KateHudson.setTimePeriod(TimePeriods.MONTHLY);
        
        kateSubordinates.add(JoanneDowman);
        kateSubordinates.add(CharlotteHond);
        
        //ScarletGreen
        ScarletGreen.setfName("Scarlet");
        ScarletGreen.setlName("Green");
        ScarletGreen.setDOB(formatter.parse("20/03/1980"));
        ScarletGreen.setStartOfWorkDate(formatter.parse("10/05/2013"));
        ScarletGreen.setIsContractor(false);
        ScarletGreen.setTimePeriod(TimePeriods.MONTHLY);
        
        
        scarletSubordinates.add(ChristineBennet);
        scarletSubordinates.add(MichaelPerry);
        
        //Amanda Green
        AmandaGreen.setfName("Amanda");
        AmandaGreen.setlName("Green");
        AmandaGreen.setDOB(formatter.parse("05/04/1979"));
        AmandaGreen.setIsContractor(false);
        AmandaGreen.setTimePeriod(TimePeriods.MONTHLY);
        AmandaGreen.setStartOfWorkDate(formatter.parse("14/10/2014"));
        amandaSubordinates.add(VictoriaBell);
        amandaSubordinates.add(AndrewBlack);
        
        //Eric White
        EricWhite.setfName("Eric");
        EricWhite.setlName("White");
        EricWhite.setDOB(formatter.parse("21/05/1984"));
        EricWhite.setIsContractor(false);
        EricWhite.setTimePeriod(TimePeriods.FORTNIGHTLY);
        EricWhite.setStartOfWorkDate(formatter.parse("10/04/2011"));
        //Julia Smith
        JuliaSmith.setfName("Julia");
        JuliaSmith.setlName("Smith");
        JuliaSmith.setDOB(formatter.parse("17/02/1973"));
        JuliaSmith.setTimePeriod(TimePeriods.MONTHLY);
        juliaSubordinates.add(PeterGordon);
        JuliaSmith.setStartOfWorkDate(formatter.parse("13/06/2010"));

        //Victoria Bell
        VictoriaBell.setfName("Victoria");
        VictoriaBell.setlName("Bell");
        VictoriaBell.setDOB(formatter.parse("11/01/1978"));
        VictoriaBell.setTimePeriod(TimePeriods.FORTNIGHTLY);
        VictoriaBell.setStartOfWorkDate(formatter.parse("30/04/2013"));
        victoriaSubordinates.add(JohnNorton);
        victoriaSubordinates.add(AndrewBlank);
        victoriaSubordinates.add(JamesCarol);
        
        //Charlotte Hond
        CharlotteHond.setfName("Charlotte");
        CharlotteHond.setlName("Hond");
        CharlotteHond.setDOB(formatter.parse("01/07/1988"));
        CharlotteHond.setTimePeriod(TimePeriods.FORTNIGHTLY);
        CharlotteHond.setStartOfWorkDate(formatter.parse("28/02/2012"));
        charlotteSubordinates.add(CarolWhite);
        charlotteSubordinates.add(ElenaTang);
        charlotteSubordinates.add(TessaGreen);
        charlotteSubordinates.add(AshleySimpson);
        
        //Christine Bennet
        ChristineBennet.setfName("Christine");
        ChristineBennet.setlName("Bennet");
        ChristineBennet.setDOB(formatter.parse("16/06/1982"));
        ChristineBennet.setTimePeriod(TimePeriods.FORTNIGHTLY);
        ChristineBennet.setStartOfWorkDate(formatter.parse("11/06/2011"));
        christineSubordinates.add(DavidGalloway);
        christineSubordinates.add(BradTurner);
        christineSubordinates.add(DavidChand);
        
        //Michael Brown
        MichaelBrown.setfName("Michael");
        MichaelBrown.setlName("Brown");
        MichaelBrown.setDOB(formatter.parse("25/12/1985"));
        MichaelBrown.setTimePeriod(TimePeriods.FORTNIGHTLY);
        MichaelBrown.setStartOfWorkDate(formatter.parse("21/07/2012"));
        michaelSubordinates.add(HelenChan);
        
        
        //Peter Gordon
        PeterGordon.setfName("Peter");
        PeterGordon.setlName("Gordon");
        PeterGordon.setDOB(formatter.parse("30/09/1983"));
        PeterGordon.setTimePeriod(TimePeriods.FORTNIGHTLY);
        PeterGordon.setStartOfWorkDate(formatter.parse("10/05/2010"));
        //Helen Chan
        HelenChan.setfName("Helen");
        HelenChan.setlName("Chan");
        HelenChan.setDOB(formatter.parse("1/11/1991"));
        HelenChan.setIsContractor(true);
        
        
        //John Norton
        JohnNorton.setfName("John");
        JohnNorton.setlName("Norton");
        JohnNorton.setDOB(formatter.parse("7/17/1980"));
        JohnNorton.setTimePeriod(TimePeriods.MONTHLY);
        johnNSubordinates.add(AlexDillion);
        JohnNorton.setStartOfWorkDate(formatter.parse("10/09/2010"));
        
        //Ashley Simposon
        AshleySimpson.setfName("Ashley");
        AshleySimpson.setlName("Simpson");
        AshleySimpson.setDOB(formatter.parse("5/12/1984"));
        AshleySimpson.setTimePeriod(TimePeriods.MONTHLY);
        AshleySimpson.setStartOfWorkDate(formatter.parse("15/06/2010"));
        ashleySubordinates.add(AndrewSampson);
        
        
        //Andrew Black
        
        AndrewBlack.setfName("Andrew");
        AndrewBlack.setlName("Black");
        AndrewBlack.setDOB(formatter.parse("4/15/1976"));
        AndrewBlack.setTimePeriod(TimePeriods.MONTHLY);
        AndrewBlack.setStartOfWorkDate(formatter.parse("04/05/2012"));
        //Joanne Downman
        
        JoanneDowman.setfName("Joanna");
        JoanneDowman.setlName("Downman");
        JoanneDowman.setDOB(formatter.parse("12/13/1980"));
        JoanneDowman.setTimePeriod(TimePeriods.FORTNIGHTLY);
        JoanneDowman.setStartOfWorkDate(formatter.parse("07/07/2014"));
        //Michael Perry
        
        MichaelPerry.setfName("Michael");
        MichaelPerry.setlName("Perry");
        MichaelPerry.setDOB(formatter.parse("11/12/1977"));
        MichaelPerry.setTimePeriod(TimePeriods.FORTNIGHTLY);
        MichaelPerry.setStartOfWorkDate(formatter.parse("01/03/2014"));
       
        //Andrew Blank
        
        AndrewBlank.setfName("Andrew");
        AndrewBlank.setlName("Blank");
        AndrewBlank.setDOB(formatter.parse("9/15/1981"));
        AndrewBlank.setTimePeriod(TimePeriods.MONTHLY);
        AndrewBlank.setStartOfWorkDate(formatter.parse("19/08/2014"));
        
        //Carol White
        
        CarolWhite.setfName("Carol");
        CarolWhite.setlName("White");
        CarolWhite.setDOB(formatter.parse("10/20/1975"));
        CarolWhite.setTimePeriod(TimePeriods.MONTHLY);
        CarolWhite.setStartOfWorkDate(formatter.parse("10/01/2014"));
        //Brad Turner
        
        BradTurner.setfName("Brad");
        BradTurner.setlName("Turner");
        BradTurner.setDOB(formatter.parse("11/22/1988"));
        BradTurner.setTimePeriod(TimePeriods.MONTHLY);
        BradTurner.setStartOfWorkDate(formatter.parse("26/05/2014"));
        //JamesCarol
        
        JamesCarol.setfName("James");
        JamesCarol.setlName("Carol");
        JamesCarol.setDOB(formatter.parse("3/24/1978"));
        JamesCarol.setIsContractor(true);
        //Elena Tang
        
        ElenaTang.setfName("Elena");
        ElenaTang.setlName("Tang");
        ElenaTang.setDOB(formatter.parse("2/11/1969"));
        ElenaTang.setIsContractor(true);
        //Tessa Green
        
        TessaGreen.setfName("Tessa");
        TessaGreen.setlName("Green");
        TessaGreen.setDOB(formatter.parse("10/31/1985"));
        TessaGreen.setIsContractor(true);
        //David Chand
        
        DavidChand.setfName("David");
        DavidChand.setlName("Chand");
        DavidChand.setDOB(formatter.parse("4/11/1973"));
        DavidChand.setIsContractor(true);
        //Alex Dillon
        
        AlexDillion.setfName("Alex");
        AlexDillion.setlName("Dillion");
        AlexDillion.setDOB(formatter.parse("10/03/1989"));
        AlexDillion.setTimePeriod(TimePeriods.FORTNIGHTLY);
        AlexDillion.setStartOfWorkDate(formatter.parse("14/09/2014"));
        //Andrew Sampson
        
        AndrewSampson.setfName("Andrew");
        AndrewSampson.setlName("Sampson");
        AndrewSampson.setDOB(formatter.parse("09/04/1984"));
        AndrewSampson.setTimePeriod(TimePeriods.FORTNIGHTLY);
        AndrewSampson.setStartOfWorkDate(formatter.parse("04/07/2010"));
        //David Galloway
        
        DavidGalloway.setfName("David");
        DavidGalloway.setlName("Galloway");
        DavidGalloway.setDOB(formatter.parse("6/12/1981"));
        DavidGalloway.setTimePeriod(TimePeriods.MONTHLY);
        DavidGalloway.setStartOfWorkDate(formatter.parse("05/11/2013"));
        
                
                
        /**
         * Then Add them to an Array List
         */
        
        person.add(JamesMint);
        person.add(BillJohns);
        person.add(KateHudson);
        person.add(ElenaTang);
        person.add(JohnNorton);
        person.add(AlexDillion);
        person.add(ScarletGreen);
        person.add(AmandaGreen);
        person.add(EricWhite);
        person.add(JuliaSmith);
        person.add(AndrewSampson);
        person.add(DavidGalloway);
        person.add(VictoriaBell);
        person.add(CharlotteHond);
        person.add(ChristineBennet);
        person.add(PeterGordon);
        person.add(MichaelBrown);
        person.add(HelenChan);
        person.add(AshleySimpson);
        person.add(AndrewBlack);
        person.add(JoanneDowman);
        person.add(MichaelPerry);
        person.add(AndrewBlank);
        person.add(CarolWhite);
        person.add(BradTurner);
        person.add(JamesCarol);
        person.add(TessaGreen);
        person.add(DavidChand);
        
        
        
        
        
        MainForm frame = new MainForm(person);
        frame.setVisible(true);
    }
    
}
