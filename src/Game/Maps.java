package Game;

import java.util.*;
import java.util.Map.Entry;

public class Maps {

    public Set<Node> nodes = new HashSet<>();

    public static List<Node> j4Route;

    public static List<Node> w31Route;


    public void addNode(Node nodeA){
        nodes.add(nodeA);
    }

    public static Maps calculateShortestPathFromSource(Maps graph, Node source){
        source.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes= new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() !=0){
            Node currentNode=getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for(Entry <Node, Integer> adjacencyPair: currentNode.getAdjacentNodes().entrySet()){
                Node adjacentNode=adjacencyPair.getKey();

                int speed;
                if (Objects.equals(currentNode.getTransportType(), "Walk")){
                    speed=Player.speed;
                } else if (Objects.equals(currentNode.getTransportType(), "Bus")){
                    if(Level.isBusFilter()) {
                        speed = Bus.speed;
                    }else{
                        speed=1;
                    }
                }else if(Objects.equals(currentNode.getTransportType(), "Bike")){
                    if(Level.isBikeFilter()) {
                        speed = Bike.speed;
                    }else{
                        speed=1;
                    }
                }else if(Objects.equals(currentNode.getTransportType(), "Car")){
                    if(Level.isCarFilter()) {
                        speed = Car.speed;
                    }else{
                        speed=1;
                    }
                }else{
                    speed=1;
                }

                Integer edgeWeight = adjacencyPair.getValue()/speed;

                if (!settledNodes.contains(adjacentNode)){
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
                settledNodes.add(currentNode);
            }
        }
        return graph;
    }


    private static Node getLowestDistanceNode(Set <Node> unsettledNodes){
        Node lowestDistanceNode=null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes){
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance){
                lowestDistance=nodeDistance;
                lowestDistanceNode=node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode){
        Integer sourceDistance = sourceNode.getDistance();

        if (sourceDistance + edgeWeight< evaluationNode.getDistance()){
            evaluationNode.setDistance(sourceDistance+edgeWeight);
            LinkedList<Node> shortestPath = new LinkedList<> (sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public static List<Node> routeBetweenNodes(Maps graph, Node startPoint, Node endPoint){
//        if (endPoint.getShortestPath()!=null){
//            endPoint.setShortestPath(null);
//        }
        Maps.calculateShortestPathFromSource(graph, startPoint);
        return (List<Node>) endPoint.getShortestPath();
    }

    public static List<Node> getJ4Route() {
        return j4Route;
    }

    public static List<Node> getW31Route() {
        return w31Route;
    }

    public static List<Node> createMap1(Maps graph){

        List<Node> nodeList=new ArrayList<>();

        Node nodeA = new Node("A",16,516);
        Node nodeB = new Node("B",16,607);
        Node nodeC = new Node("C",23,748);
        Node nodeD = new Node("D",78,757);
        Node nodeE = new Node("E",78,607);
        Node nodeF = new Node("F",219,739);
        Node nodeG = new Node("G",219,640);
        Node nodeH = new Node("H",144,608);
        Node nodeI = new Node("I",144,640);
        Node nodeJ = new Node("J",144,513);
        Node nodeK = new Node("K",247,556);
        Node nodeL = new Node("L",298,556);
        Node nodeM = new Node("M",300,640);
        Node nodeN = new Node("N",321,739);
        Node nodeO = new Node("O",312,710);
        Node nodeP = new Node("P",463,739);
        Node nodeQ = new Node("Q",463,715);
        Node nodeR = new Node("R",440,640);
        Node nodeS = new Node("S",579,770);
        Node nodeT = new Node("T",622,770);
        Node nodeU = new Node("U",622,723);
        Node nodeV = new Node("V",579,723);
        Node nodeW = new Node("W",517,713);
        Node nodeX = new Node("X",430,675);
        Node nodeY = new Node("Y",529,640);
        Node nodeZ = new Node("Z",622,640);
        Node nodeAA = new Node("AA",390,570);
        Node nodeAB = new Node("AB",390,640);
        Node nodeAC = new Node("AC",390,512);
        Node nodeAD = new Node("AD",247,512);
        Node nodeAE = new Node("AE",247,413);
        Node nodeAF = new Node("AF",144,268);
        Node nodeAG = new Node("AG",78,268);
        Node nodeAH = new Node("AH",22,268);
        Node nodeAI = new Node("AI",22,198);
        Node nodeAJ = new Node("AJ",78,198);
        Node nodeAK = new Node("AK",224,268);
        Node nodeAL = new Node("AL",410,268);
        Node nodeAM = new Node("AM",550,268);
        Node nodeAN = new Node("AN",622,268);
        Node nodeAO = new Node("AO",622,358);
        Node nodeAP = new Node("AP",622,433);
        Node nodeAQ = new Node("AQ",622,570);
        Node nodeAR = new Node("AR",743,702);
        Node nodeAS = new Node("AS",785,735);
        Node nodeAT = new Node("AT",807,752);
        Node nodeAU = new Node("AU",843,718);
        Node nodeAV = new Node("AV",752,759);
        Node nodeAW = new Node("AW",870,640);
        Node nodeAX = new Node("AX",870,588);
        Node nodeAY = new Node("AY",805,471);
        Node nodeAZ = new Node("AZ",759,526);
        Node nodeBA = new Node("BA",759,585);
        Node nodeBB = new Node("BB",674,585);
        Node nodeBC = new Node("BC",674,526);
        Node nodeBD = new Node("BD",784,433);
        Node nodeBE = new Node("BE",744,358);
        Node nodeBF = new Node("BF",870,358);
        Node nodeBG = new Node("BG",870,425);
        Node nodeBH = new Node("BH",1169,425);
        Node nodeBI = new Node("BI",1169,640);
        Node nodeBJ = new Node("BJ",1132,640);
        Node nodeBK = new Node("BK",1132,729);
        Node nodeBL = new Node("BL",1084,729);
        Node nodeBM = new Node("BM",1153,760);
        Node nodeBN = new Node("BN",1126,776);
        Node nodeBO = new Node("BO",1164,776);
        Node nodeBP = new Node("BP",1169,198);
        Node nodeBQ = new Node("BQ",870,223);
        Node nodeBR = new Node("BR",870,198);
        Node nodeBS = new Node("BS",744,223);
        Node nodeBT = new Node("BT",744,179);
        Node nodeBU = new Node("BU",744,317);
        Node nodeBV = new Node("BV",685,315);
        Node nodeBW = new Node("BW",668,221);
        Node nodeBX = new Node("BX",668,159);
        Node nodeBY = new Node("BY",604,216);
        Node nodeBZ = new Node("BZ",604,160);
        Node nodeCA = new Node("CA",870,160);
        Node nodeCB = new Node("CB",1115,160);
        Node nodeCC = new Node("CC",1115,126);
        Node nodeCD = new Node("CD",1115,12);
        Node nodeCE = new Node("CE",1173,126);
        Node nodeCF = new Node("CF",870,126);
        Node nodeCG = new Node("CG",410,126);
        Node nodeCH = new Node("CH",410,75);
        Node nodeCI = new Node("CI",410,160);
        Node nodeCJ = new Node("CJ",550,160);
        Node nodeCK = new Node("CK",550,238);
        Node nodeCL = new Node("CL",410,238);
        Node nodeCM = new Node("CM",224,196);
        Node nodeCN = new Node("CN",224,160);
        Node nodeCO = new Node("CO",144,160);
        Node nodeCP = new Node("CP",144,126);
        Node nodeCQ = new Node("CQ",144,75);
        Node nodeCR = new Node("CR",224,126);
        Node nodeCS = new Node("CS",300,126);
        Node nodeCT = new Node("CT",300,75);
        Node nodeCU = new Node("CU",300,18);
        Node nodeCV = new Node("CV",410,18);
        Node nodeCX = new Node("CX",546,75);
        Node nodeCY = new Node("CY",546,22);
        Node nodeCZ = new Node("CZ",673,75);
        Node nodeDA = new Node("DA",673,22);
        Node nodeDB = new Node("DB",809,75);
        Node nodeDC = new Node("DC",809,14);
        Node nodeDD = new Node("DD",144,196);
        Node nodeDF = new Node("DF",842,640);
        Node nodeStop1 = new Node("Stop1",152,748);
        Node nodeStop2 = new Node("Stop2",500,749);
        Node nodeStop3 = new Node("Stop3",750,640);
        Node nodeStop4 = new Node("Stop4",844,541);
        Node nodeStop5 = new Node("Stop5",622,295);
        Node nodeStop6 = new Node("Stop6", 300,268);
        Node nodeStop7 = new Node("Stop7", 78,120);
        Node nodeStop8 = new Node("Stop8", 1169,500);
        Node nodeStop9 = new Node("Stop9", 903,198);
        Node nodeStop10 = new Node("Stop10", 440,160);
        Node nodeStop11 = new Node("Stop11", 300,100);
        Node nodeStop12 = new Node("Stop12", 600,75);
        Node nodeStop13 = new Node("Stop13", 809,58);
        Node nodeBStop1 = new Node("BStop1",78, 473);
        Node nodeBStop2 = new Node("BStop2",472,328);
        Node nodeBStop3 = new Node("BStop3",506,570);
        Node nodeBStop4 = new Node("BStop4",709,721);
        Node nodeBStop5 = new Node("BStop5",945,640);
        Node nodeBStop6 = new Node("BStop6",900,126);
        Node nodeBStop7 = new Node("BStop7",222,75);


        nodeA.addDestination(nodeB);

        nodeB.addDestination(nodeA);
        nodeB.addDestination(nodeC);
        nodeB.addDestination(nodeE);

        nodeC.addDestination(nodeB);
        nodeC.addDestination(nodeD);

        nodeD.addDestination(nodeC);
        nodeD.addDestination(nodeE);
        nodeD.addDestination(nodeStop1);

        nodeE.addDestination(nodeB);
        nodeE.addDestination(nodeD);
        nodeE.addDestination(nodeH);
        nodeE.addDestination(nodeBStop1);

        nodeF.addDestination(nodeStop1);
        nodeF.addDestination(nodeG);
        nodeF.addDestination(nodeN);

        nodeG.addDestination(nodeF);
        nodeG.addDestination(nodeI);
        nodeG.addDestination(nodeM);

        nodeH.addDestination(nodeE);
        nodeH.addDestination(nodeI);
        nodeH.addDestination(nodeJ);
        nodeH.addDestination(nodeK);

        nodeI.addDestination(nodeG);
        nodeI.addDestination(nodeH);

        nodeJ.addDestination(nodeH);
        nodeJ.addDestination(nodeAD);
        nodeJ.addDestination(nodeAF);

        nodeK.addDestination(nodeH);
        nodeK.addDestination(nodeL);
        nodeK.addDestination(nodeAD);

        nodeL.addDestination(nodeK);
        nodeL.addDestination(nodeM);
        nodeL.addDestination(nodeAA);

        nodeM.addDestination(nodeG);
        nodeM.addDestination(nodeL);
        nodeM.addDestination(nodeAB);

        nodeN.addDestination(nodeF);
        nodeN.addDestination(nodeO);
        nodeN.addDestination(nodeP);

        nodeO.addDestination(nodeN);

        nodeP.addDestination(nodeN);
        nodeP.addDestination(nodeQ);
        nodeP.addDestination(nodeStop2);

        nodeQ.addDestination(nodeP);
        nodeQ.addDestination(nodeW);
        nodeQ.addDestination(nodeX);

        nodeR.addDestination(nodeX);
        nodeR.addDestination(nodeY);
        nodeR.addDestination(nodeAB);

        nodeS.addDestination(nodeStop2);
        nodeS.addDestination(nodeT);
        nodeS.addDestination(nodeV);

        nodeT.addDestination(nodeS);
        nodeT.addDestination(nodeU);
        nodeT.addDestination(nodeBStop4);

        nodeU.addDestination(nodeT);
        nodeU.addDestination(nodeV);
        nodeU.addDestination(nodeZ);

        nodeV.addDestination(nodeS);
        nodeV.addDestination(nodeU);
        nodeV.addDestination(nodeW);

        nodeW.addDestination(nodeQ);
        nodeW.addDestination(nodeV);
        nodeW.addDestination(nodeY);

        nodeX.addDestination(nodeQ);
        nodeX.addDestination(nodeR);

        nodeY.addDestination(nodeR);
        nodeY.addDestination(nodeW);
        nodeY.addDestination(nodeZ);

        nodeZ.addDestination(nodeU);
        nodeZ.addDestination(nodeY);
        nodeZ.addDestination(nodeAQ);
        nodeZ.addDestination(nodeStop3);

        nodeAA.addDestination(nodeL);
        nodeAA.addDestination(nodeAB);
        nodeAA.addDestination(nodeAC);
        nodeAA.addDestination(nodeBStop3);

        nodeAB.addDestination(nodeM);
        nodeAB.addDestination(nodeR);
        nodeAB.addDestination(nodeAA);

        nodeAC.addDestination(nodeAA);
        nodeAC.addDestination(nodeAD);

        nodeAD.addDestination(nodeJ);
        nodeAD.addDestination(nodeK);
        nodeAD.addDestination(nodeAC);
        nodeAD.addDestination(nodeAE);

        nodeAE.addDestination(nodeAD);
        nodeAE.addDestination(nodeAF);
        nodeAE.addDestination(nodeBStop2);

        nodeAF.addDestination(nodeJ);
        nodeAF.addDestination(nodeAE);
        nodeAF.addDestination(nodeAG);
        nodeAF.addDestination(nodeAK);
        nodeAF.addDestination(nodeDD);

        nodeAG.addDestination(nodeBStop1);
        nodeAG.addDestination(nodeAF);
        nodeAG.addDestination(nodeAH);
        nodeAG.addDestination(nodeAJ);

        nodeAH.addDestination(nodeAG);
        nodeAH.addDestination(nodeAI);

        nodeAI.addDestination(nodeAH);
        nodeAI.addDestination(nodeAJ);

        nodeAJ.addDestination(nodeDD);
        nodeAJ.addDestination(nodeAJ);
        nodeAJ.addDestination(nodeStop7);

        nodeAK.addDestination(nodeAF);
        nodeAK.addDestination(nodeStop6);
        nodeAK.addDestination(nodeCM);

        nodeAL.addDestination(nodeStop6);
        nodeAL.addDestination(nodeAM);
        nodeAL.addDestination(nodeCL);

        nodeAM.addDestination(nodeAL);
        nodeAM.addDestination(nodeAN);
        nodeAM.addDestination(nodeCK);

        nodeAN.addDestination(nodeBStop2);
        nodeAN.addDestination(nodeAM);
        nodeAN.addDestination(nodeStop5);
        nodeAN.addDestination(nodeBY);

        nodeAO.addDestination(nodeStop5);
        nodeAO.addDestination(nodeAP);
        nodeAO.addDestination(nodeBE);

        nodeAP.addDestination(nodeAO);
        nodeAP.addDestination(nodeAQ);
        nodeAP.addDestination(nodeBD);

        nodeAQ.addDestination(nodeZ);
        nodeAQ.addDestination(nodeBStop3);
        nodeAQ.addDestination(nodeAP);

        nodeAQ.addDestination(nodeZ);
        nodeAQ.addDestination(nodeAA);
        nodeAQ.addDestination(nodeAP);

        nodeAR.addDestination(nodeBStop4);
        nodeAR.addDestination(nodeAS);
        nodeAR.addDestination(nodeDF);

        nodeAS.addDestination(nodeAR);
        nodeAS.addDestination(nodeAT);
        nodeAS.addDestination(nodeAV);

        nodeAT.addDestination(nodeAS);
        nodeAT.addDestination(nodeAU);

        nodeAU.addDestination(nodeAT);

        nodeAV.addDestination(nodeAS);

        nodeAW.addDestination(nodeAX);
        nodeAW.addDestination(nodeBStop5);
        nodeAW.addDestination(nodeDF);

        nodeAX.addDestination(nodeAW);
        nodeAX.addDestination(nodeStop4);
        nodeAX.addDestination(nodeBG);

        nodeAY.addDestination(nodeStop4);
        nodeAY.addDestination(nodeAZ);
        nodeAY.addDestination(nodeBD);

        nodeAZ.addDestination(nodeAY);
        nodeAZ.addDestination(nodeBA);
        nodeAZ.addDestination(nodeBC);

        nodeBA.addDestination(nodeAZ);
        nodeBA.addDestination(nodeBB);

        nodeBB.addDestination(nodeBA);

        nodeBC.addDestination(nodeAZ);

        nodeBD.addDestination(nodeAP);
        nodeBD.addDestination(nodeAY);
        nodeBD.addDestination(nodeBE);

        nodeBE.addDestination(nodeAO);
        nodeBE.addDestination(nodeBD);
        nodeBE.addDestination(nodeBF);
        nodeBE.addDestination(nodeBU);

        nodeBF.addDestination(nodeBE);
        nodeBF.addDestination(nodeBG);
        nodeBF.addDestination(nodeBQ);

        nodeBG.addDestination(nodeAX);
        nodeBG.addDestination(nodeBF);
        nodeBG.addDestination(nodeBH);

        nodeBH.addDestination(nodeBG);
        nodeBH.addDestination(nodeStop8);
        nodeBH.addDestination(nodeBP);

        nodeBI.addDestination(nodeStop8);
        nodeBI.addDestination(nodeBJ);

        nodeBJ.addDestination(nodeBStop5);
        nodeBJ.addDestination(nodeBI);
        nodeBJ.addDestination(nodeBK);

        nodeBK.addDestination(nodeBJ);
        nodeBK.addDestination(nodeBL);
        nodeBK.addDestination(nodeBM);

        nodeBL.addDestination(nodeBK);

        nodeBM.addDestination(nodeBK);
        nodeBM.addDestination(nodeBN);
        nodeBM.addDestination(nodeBO);

        nodeBN.addDestination(nodeBM);

        nodeBO.addDestination(nodeBM);

        nodeBP.addDestination(nodeBH);
        nodeBP.addDestination(nodeStop9);

        nodeBQ.addDestination(nodeBF);
        nodeBQ.addDestination(nodeBR);
        nodeBQ.addDestination(nodeBS);

        nodeBR.addDestination(nodeStop9);
        nodeBR.addDestination(nodeBQ);
        nodeBR.addDestination(nodeCA);

        nodeBS.addDestination(nodeBQ);
        nodeBS.addDestination(nodeBT);
        nodeBS.addDestination(nodeBU);

        nodeBT.addDestination(nodeBS);

        nodeBU.addDestination(nodeBE);
        nodeBU.addDestination(nodeBS);
        nodeBU.addDestination(nodeBV);

        nodeBV.addDestination(nodeBU);
        nodeBV.addDestination(nodeBW);

        nodeBW.addDestination(nodeBV);
        nodeBW.addDestination(nodeBX);
        nodeBW.addDestination(nodeBY);

        nodeBX.addDestination(nodeBW);
        nodeBX.addDestination(nodeBZ);
        nodeBX.addDestination(nodeCA);

        nodeBY.addDestination(nodeAN);
        nodeBY.addDestination(nodeBW);
        nodeBY.addDestination(nodeBZ);

        nodeBZ.addDestination(nodeBX);
        nodeBZ.addDestination(nodeBZ);
        nodeBZ.addDestination(nodeCJ);

        nodeCA.addDestination(nodeBR);
        nodeCA.addDestination(nodeBX);
        nodeCA.addDestination(nodeCB);
        nodeCA.addDestination(nodeCF);

        nodeCB.addDestination(nodeCA);
        nodeCB.addDestination(nodeCC);

        nodeCC.addDestination(nodeCB);
        nodeCC.addDestination(nodeCD);
        nodeCC.addDestination(nodeCE);
        nodeCC.addDestination(nodeBStop6);

        nodeCD.addDestination(nodeCC);

        nodeCE.addDestination(nodeCC);

        nodeCF.addDestination(nodeCA);
        nodeCF.addDestination(nodeBStop6);
        nodeCF.addDestination(nodeCG);

        nodeCG.addDestination(nodeCF);
        nodeCG.addDestination(nodeCH);
        nodeCG.addDestination(nodeCI);
        nodeCG.addDestination(nodeCS);

        nodeCH.addDestination(nodeCG);
        nodeCH.addDestination(nodeCT);
        nodeCH.addDestination(nodeCV);
        nodeCH.addDestination(nodeCX);

        nodeCI.addDestination(nodeCG);
        nodeCI.addDestination(nodeStop10);
        nodeCI.addDestination(nodeCL);
        nodeCI.addDestination(nodeCN);

        nodeCJ.addDestination(nodeBZ);
        nodeCJ.addDestination(nodeStop10);
        nodeCJ.addDestination(nodeCK);

        nodeCK.addDestination(nodeAM);
        nodeCK.addDestination(nodeCJ);
        nodeCK.addDestination(nodeCL);

        nodeCL.addDestination(nodeAL);
        nodeCL.addDestination(nodeCI);
        nodeCL.addDestination(nodeCK);

        nodeCM.addDestination(nodeAK);
        nodeCM.addDestination(nodeCN);
        nodeCM.addDestination(nodeDD);

        nodeCN.addDestination(nodeCI);
        nodeCN.addDestination(nodeCM);
        nodeCN.addDestination(nodeCO);
        nodeCN.addDestination(nodeCR);

        nodeCO.addDestination(nodeCN);
        nodeCO.addDestination(nodeCP);
        nodeCO.addDestination(nodeDD);

        nodeCP.addDestination(nodeCO);
        nodeCP.addDestination(nodeCQ);
        nodeCP.addDestination(nodeCR);

        nodeCQ.addDestination(nodeCP);
        nodeCQ.addDestination(nodeBStop7);

        nodeCR.addDestination(nodeCN);
        nodeCR.addDestination(nodeCP);
        nodeCR.addDestination(nodeCS);

        nodeCS.addDestination(nodeCG);
        nodeCS.addDestination(nodeCR);
        nodeCS.addDestination(nodeStop11);

        nodeCT.addDestination(nodeCH);
        nodeCT.addDestination(nodeBStop7);
        nodeCT.addDestination(nodeStop11);
        nodeCT.addDestination(nodeCU);

        nodeCU.addDestination(nodeCT);
        nodeCU.addDestination(nodeCV);

        nodeCV.addDestination(nodeCH);
        nodeCV.addDestination(nodeCU);

        nodeCX.addDestination(nodeCH);
        nodeCX.addDestination(nodeCY);
        nodeCX.addDestination(nodeStop12);

        nodeCY.addDestination(nodeCX);

        nodeCZ.addDestination(nodeStop12);
        nodeCZ.addDestination(nodeDA);
        nodeCZ.addDestination(nodeDB);

        nodeDA.addDestination(nodeCZ);

        nodeDB.addDestination(nodeCZ);
        nodeDB.addDestination(nodeStop13);

        nodeDC.addDestination(nodeStop13);

        nodeDD.addDestination(nodeAF);
        nodeDD.addDestination(nodeAJ);
        nodeDD.addDestination(nodeCM);
        nodeDD.addDestination(nodeCO);

        nodeDF.addDestination(nodeStop3);
        nodeDF.addDestination(nodeAR);
        nodeDF.addDestination(nodeAW);

        nodeStop1.addDestination(nodeD);
        nodeStop1.addDestination(nodeF);

        nodeStop2.addDestination(nodeP);
        nodeStop2.addDestination(nodeS);

        nodeStop3.addDestination(nodeZ);
        nodeStop3.addDestination(nodeDF);

        nodeStop4.addDestination(nodeAX);
        nodeStop4.addDestination(nodeAY);

        nodeStop5.addDestination(nodeAN);
        nodeStop5.addDestination(nodeAO);

        nodeStop6.addDestination(nodeAK);
        nodeStop6.addDestination(nodeAL);

        nodeStop7.addDestination(nodeAJ);

        nodeStop8.addDestination(nodeBI);
        nodeStop8.addDestination(nodeBH);

        nodeStop9.addDestination(nodeBP);
        nodeStop9.addDestination(nodeBR);

        nodeStop10.addDestination(nodeCJ);
        nodeStop10.addDestination(nodeCI);

        nodeStop11.addDestination(nodeCS);
        nodeStop11.addDestination(nodeCT);

        nodeStop12.addDestination(nodeCX);
        nodeStop12.addDestination(nodeCZ);

        nodeStop13.addDestination(nodeDB);
        nodeStop13.addDestination(nodeDC);

        nodeBStop1.addDestination(nodeE);
        nodeBStop1.addDestination(nodeAG);

        nodeBStop2.addDestination(nodeAE);
        nodeBStop2.addDestination(nodeAN);

        nodeBStop3.addDestination(nodeAA);
        nodeBStop3.addDestination(nodeAQ);

        nodeBStop4.addDestination(nodeT);
        nodeBStop4.addDestination(nodeAR);

        nodeBStop5.addDestination(nodeAW);
        nodeBStop5.addDestination(nodeBJ);

        nodeBStop6.addDestination(nodeCC);
        nodeBStop6.addDestination(nodeCF);

        nodeBStop7.addDestination(nodeCQ);
        nodeBStop7.addDestination(nodeCT);

        nodeList.add(nodeA);
        nodeList.add(nodeB);
        nodeList.add(nodeC);
        nodeList.add(nodeD);
        nodeList.add(nodeE);
        nodeList.add(nodeF);
        nodeList.add(nodeG);
        nodeList.add(nodeH);
        nodeList.add(nodeI);
        nodeList.add(nodeJ);
        nodeList.add(nodeK);
        nodeList.add(nodeL);
        nodeList.add(nodeM);
        nodeList.add(nodeN);
        nodeList.add(nodeO);
        nodeList.add(nodeP);
        nodeList.add(nodeQ);
        nodeList.add(nodeR);
        nodeList.add(nodeS);
        nodeList.add(nodeT);
        nodeList.add(nodeU);
        nodeList.add(nodeV);
        nodeList.add(nodeW);
        nodeList.add(nodeX);
        nodeList.add(nodeY);
        nodeList.add(nodeZ);
        nodeList.add(nodeAA);
        nodeList.add(nodeAB);
        nodeList.add(nodeAC);
        nodeList.add(nodeAD);
        nodeList.add(nodeAE);
        nodeList.add(nodeAF);
        nodeList.add(nodeAG);
        nodeList.add(nodeAH);
        nodeList.add(nodeAI);
        nodeList.add(nodeAJ);
        nodeList.add(nodeAK);
        nodeList.add(nodeAL);
        nodeList.add(nodeAM);
        nodeList.add(nodeAN);
        nodeList.add(nodeAO);
        nodeList.add(nodeAP);
        nodeList.add(nodeAQ);
        nodeList.add(nodeAR);
        nodeList.add(nodeAS);
        nodeList.add(nodeAT);
        nodeList.add(nodeAU);
        nodeList.add(nodeAV);
        nodeList.add(nodeAW);
        nodeList.add(nodeAX);
        nodeList.add(nodeAY);
        nodeList.add(nodeAZ);
        nodeList.add(nodeBA);
        nodeList.add(nodeBB);
        nodeList.add(nodeBC);
        nodeList.add(nodeBD);
        nodeList.add(nodeBE);
        nodeList.add(nodeBF);
        nodeList.add(nodeBG);
        nodeList.add(nodeBH);
        nodeList.add(nodeBI);
        nodeList.add(nodeBJ);
        nodeList.add(nodeBK);
        nodeList.add(nodeBL);
        nodeList.add(nodeBM);
        nodeList.add(nodeBN);
        nodeList.add(nodeBO);
        nodeList.add(nodeBP);
        nodeList.add(nodeBQ);
        nodeList.add(nodeBR);
        nodeList.add(nodeBS);
        nodeList.add(nodeBT);
        nodeList.add(nodeBU);
        nodeList.add(nodeBV);
        nodeList.add(nodeBW);
        nodeList.add(nodeBX);
        nodeList.add(nodeBY);
        nodeList.add(nodeBZ);
        nodeList.add(nodeCA);
        nodeList.add(nodeCB);
        nodeList.add(nodeCC);
        nodeList.add(nodeCD);
        nodeList.add(nodeCE);
        nodeList.add(nodeCF);
        nodeList.add(nodeCG);
        nodeList.add(nodeCH);
        nodeList.add(nodeCI);
        nodeList.add(nodeCJ);
        nodeList.add(nodeCK);
        nodeList.add(nodeCL);
        nodeList.add(nodeCM);
        nodeList.add(nodeCN);
        nodeList.add(nodeCO);
        nodeList.add(nodeCP);
        nodeList.add(nodeCQ);
        nodeList.add(nodeCR);
        nodeList.add(nodeCS);
        nodeList.add(nodeCT);
        nodeList.add(nodeCU);
        nodeList.add(nodeCV);
        nodeList.add(nodeCX);
        nodeList.add(nodeCY);
        nodeList.add(nodeCZ);
        nodeList.add(nodeDA);
        nodeList.add(nodeDB);
        nodeList.add(nodeDC);
        nodeList.add(nodeDD);
        nodeList.add(nodeDF);
        nodeList.add(nodeStop1);
        nodeList.add(nodeStop2);
        nodeList.add(nodeStop3);
        nodeList.add(nodeStop4);
        nodeList.add(nodeStop5);
        nodeList.add(nodeStop6);
        nodeList.add(nodeStop7);
        nodeList.add(nodeStop8);
        nodeList.add(nodeStop9);
        nodeList.add(nodeStop10);
        nodeList.add(nodeStop11);
        nodeList.add(nodeStop12);
        nodeList.add(nodeStop13);
        nodeList.add(nodeBStop1);
        nodeList.add(nodeBStop2);
        nodeList.add(nodeBStop3);
        nodeList.add(nodeBStop4);
        nodeList.add(nodeBStop5);
        nodeList.add(nodeBStop6);
        nodeList.add(nodeBStop7);

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);
        graph.addNode(nodeH);
        graph.addNode(nodeI);
        graph.addNode(nodeJ);
        graph.addNode(nodeK);
        graph.addNode(nodeL);
        graph.addNode(nodeM);
        graph.addNode(nodeN);
        graph.addNode(nodeO);
        graph.addNode(nodeP);
        graph.addNode(nodeQ);
        graph.addNode(nodeR);
        graph.addNode(nodeS);
        graph.addNode(nodeT);
        graph.addNode(nodeU);
        graph.addNode(nodeV);
        graph.addNode(nodeW);
        graph.addNode(nodeX);
        graph.addNode(nodeY);
        graph.addNode(nodeZ);
        graph.addNode(nodeAA);
        graph.addNode(nodeAB);
        graph.addNode(nodeAC);
        graph.addNode(nodeAD);
        graph.addNode(nodeAE);
        graph.addNode(nodeAF);
        graph.addNode(nodeAG);
        graph.addNode(nodeAH);
        graph.addNode(nodeAI);
        graph.addNode(nodeAJ);
        graph.addNode(nodeAK);
        graph.addNode(nodeAL);
        graph.addNode(nodeAM);
        graph.addNode(nodeAN);
        graph.addNode(nodeAO);
        graph.addNode(nodeAP);
        graph.addNode(nodeAQ);
        graph.addNode(nodeAR);
        graph.addNode(nodeAS);
        graph.addNode(nodeAT);
        graph.addNode(nodeAU);
        graph.addNode(nodeAV);
        graph.addNode(nodeAW);
        graph.addNode(nodeAX);
        graph.addNode(nodeAY);
        graph.addNode(nodeAZ);
        graph.addNode(nodeBA);
        graph.addNode(nodeBB);
        graph.addNode(nodeBC);
        graph.addNode(nodeBD);
        graph.addNode(nodeBE);
        graph.addNode(nodeBF);
        graph.addNode(nodeBG);
        graph.addNode(nodeBH);
        graph.addNode(nodeBI);
        graph.addNode(nodeBJ);
        graph.addNode(nodeBK);
        graph.addNode(nodeBL);
        graph.addNode(nodeBM);
        graph.addNode(nodeBN);
        graph.addNode(nodeBO);
        graph.addNode(nodeBP);
        graph.addNode(nodeBQ);
        graph.addNode(nodeBR);
        graph.addNode(nodeBS);
        graph.addNode(nodeBT);
        graph.addNode(nodeBU);
        graph.addNode(nodeBV);
        graph.addNode(nodeBW);
        graph.addNode(nodeBX);
        graph.addNode(nodeBY);
        graph.addNode(nodeBZ);
        graph.addNode(nodeCA);
        graph.addNode(nodeCB);
        graph.addNode(nodeCC);
        graph.addNode(nodeCD);
        graph.addNode(nodeCE);
        graph.addNode(nodeCF);
        graph.addNode(nodeCG);
        graph.addNode(nodeCH);
        graph.addNode(nodeCI);
        graph.addNode(nodeCJ);
        graph.addNode(nodeCK);
        graph.addNode(nodeCL);
        graph.addNode(nodeCM);
        graph.addNode(nodeCN);
        graph.addNode(nodeCO);
        graph.addNode(nodeCP);
        graph.addNode(nodeCQ);
        graph.addNode(nodeCR);
        graph.addNode(nodeCS);
        graph.addNode(nodeCT);
        graph.addNode(nodeCU);
        graph.addNode(nodeCV);
        graph.addNode(nodeCX);
        graph.addNode(nodeCY);
        graph.addNode(nodeCZ);
        graph.addNode(nodeDA);
        graph.addNode(nodeDB);
        graph.addNode(nodeDC);
        graph.addNode(nodeDD);
        graph.addNode(nodeDF);
        graph.addNode(nodeStop1);
        graph.addNode(nodeStop2);
        graph.addNode(nodeStop3);
        graph.addNode(nodeStop4);
        graph.addNode(nodeStop5);
        graph.addNode(nodeStop6);
        graph.addNode(nodeStop7);
        graph.addNode(nodeStop8);
        graph.addNode(nodeStop9);
        graph.addNode(nodeStop10);
        graph.addNode(nodeStop11);
        graph.addNode(nodeStop12);
        graph.addNode(nodeStop13);
        graph.addNode(nodeBStop1);
        graph.addNode(nodeBStop2);
        graph.addNode(nodeBStop3);
        graph.addNode(nodeBStop4);
        graph.addNode(nodeBStop5);
        graph.addNode(nodeBStop6);
        graph.addNode(nodeBStop7);

        //Mapping J4 Route

        Node J4Start = new Node("J4Start",-300,nodeC.getY(),Bus.transportType);
        Node nodeCb = new Node("Cb",nodeC.getX(),nodeC.getY(), Bus.transportType);
        Node nodeDb = new Node("Db",nodeD.getX(),nodeD.getY(),Bus.transportType);
        Node nodeStop1b = new Node("Stop1b",nodeStop1.getX(),nodeStop1.getY(), Bus.transportType,true);
        Node nodeFb = new Node("Fb",nodeF.getX(),nodeF.getY(),Bus.transportType);
        Node nodePb = new Node("Pb",nodeP.getX(),nodeP.getY(),Bus.transportType);
        Node nodeStop2b = new Node("Stop2b",nodeStop2.getX(),nodeStop2.getY(),Bus.transportType,true);
        Node nodeSb = new Node("Sb",nodeS.getX(),nodeS.getY(),Bus.transportType);
        Node nodeTb = new Node("Tb",nodeT.getX(),nodeT.getY(),Bus.transportType);
        Node nodeZb = new Node("Zb",nodeZ.getX(),nodeZ.getY(),Bus.transportType);
        Node nodeStop3b = new Node("Stop3b",nodeStop3.getX(),nodeStop3.getY(),Bus.transportType,true);
        Node nodeDFb = new Node("DFb",nodeDF.getX(),nodeDF.getY(),Bus.transportType);
        Node nodeAWb = new Node("AWb",nodeAW.getX(),nodeAW.getY(),Bus.transportType);
        Node nodeAXb = new Node("AXb",nodeAX.getX(),nodeAX.getY(),Bus.transportType);
        Node nodeStop4b = new Node("Stop4b",nodeStop4.getX(),nodeStop4.getY(),Bus.transportType,true);
        Node nodeAYb = new Node("AYb",nodeAY.getX(),nodeAY.getY(),Bus.transportType);
        Node nodeBDb = new Node("BDb",nodeBD.getX(),nodeBD.getY(),Bus.transportType);
        Node nodeBEb = new Node("BEb",nodeBE.getX(),nodeBE.getY(),Bus.transportType);
        Node nodeAOb = new Node("AOb",nodeAO.getX(),nodeAO.getY(),Bus.transportType);
        Node nodeStop5b = new Node("Stop5b",nodeStop5.getX(),nodeStop5.getY(),Bus.transportType,true);
        Node nodeANb = new Node("ANb",nodeAN.getX(),nodeAN.getY(),Bus.transportType);
        Node nodeAMb = new Node("AMb",nodeAM.getX(),nodeAM.getY(),Bus.transportType);
        Node nodeALb = new Node("ALb",nodeAL.getX(),nodeAL.getY(),Bus.transportType);
        Node nodeStop6b = new Node("Stop6b",nodeStop6.getX(),nodeStop6.getY(),Bus.transportType,true);
        Node nodeAKb = new Node("AKb",nodeAK.getX(),nodeAK.getY(),Bus.transportType);
        Node nodeAGb = new Node("AGb",nodeAG.getX(),nodeAG.getY(),Bus.transportType);
        Node nodeAJb = new Node("AJb",nodeAG.getX(),nodeAJ.getY(),Bus.transportType);
        Node nodeStop7b = new Node("Stop7b",nodeStop7.getX(),nodeStop7.getY(),Bus.transportType,true);
        Node J4End = new Node("J4End",nodeStop7.getX(),-300,Bus.transportType);

        J4Start.addDestination(nodeCb);

        nodeCb.addDestination(J4Start);
        nodeCb.addDestination(nodeDb);

        nodeDb.addDestination(nodeCb);
        nodeDb.addDestination(nodeStop1b);

        nodeStop1b.addDestination(nodeDb);
        nodeStop1b.addDestination(nodeFb);

        nodeFb.addDestination(nodeStop1b);
        nodeFb.addDestination(nodePb);

        nodePb.addDestination(nodeFb);
        nodePb.addDestination(nodeStop2b);

        nodeStop2b.addDestination(nodePb);
        nodeStop2b.addDestination(nodeSb);

        nodeSb.addDestination(nodeStop2b);
        nodeSb.addDestination(nodeTb);

        nodeTb.addDestination(nodeSb);
        nodeTb.addDestination(nodeZb);

        nodeZb.addDestination(nodeTb);
        nodeZb.addDestination(nodeStop3b);

        nodeStop3b.addDestination(nodeZb);
        nodeStop3b.addDestination(nodeDFb);

        nodeDFb.addDestination(nodeStop3b);
        nodeDFb.addDestination(nodeAWb);

        nodeAWb.addDestination(nodeDFb);
        nodeAWb.addDestination(nodeAXb);

        nodeAXb.addDestination(nodeAWb);
        nodeAXb.addDestination(nodeStop4b);

        nodeStop4b.addDestination(nodeAXb);
        nodeStop4b.addDestination(nodeAYb);

        nodeAYb.addDestination(nodeStop4b);
        nodeAYb.addDestination(nodeBDb);

        nodeBDb.addDestination(nodeAYb);
        nodeBDb.addDestination(nodeBEb);

        nodeBEb.addDestination(nodeBDb);
        nodeBEb.addDestination(nodeAOb);

        nodeAOb.addDestination(nodeBEb);
        nodeAOb.addDestination(nodeStop5b);

        nodeStop5b.addDestination(nodeAOb);
        nodeStop5b.addDestination(nodeANb);

        nodeANb.addDestination(nodeStop5b);
        nodeANb.addDestination(nodeAMb);

        nodeAMb.addDestination(nodeANb);
        nodeAMb.addDestination(nodeALb);

        nodeALb.addDestination(nodeAMb);
        nodeALb.addDestination(nodeStop6b);

        nodeStop6b.addDestination(nodeALb);
        nodeStop6b.addDestination(nodeAKb);

        nodeAKb.addDestination(nodeStop6b);
        nodeAKb.addDestination(nodeAGb);

        nodeAGb.addDestination(nodeAKb);
        nodeAGb.addDestination(nodeAJb);

        nodeAJb.addDestination(nodeAGb);
        nodeAJb.addDestination(nodeStop7b);

        nodeStop7b.addDestination(nodeAJb);
        nodeStop7b.addDestination(J4End);

        J4End.addDestination(nodeStop7b);

        nodeStop1.addDestination(nodeStop1b);
        nodeStop1b.addDestination(nodeStop1);

        nodeStop2.addDestination(nodeStop2b);
        nodeStop2b.addDestination(nodeStop2);

        nodeStop3.addDestination(nodeStop3b);
        nodeStop3b.addDestination(nodeStop3);

        nodeStop4.addDestination(nodeStop4b);
        nodeStop4b.addDestination(nodeStop4);

        nodeStop5.addDestination(nodeStop5b);
        nodeStop5b.addDestination(nodeStop5);

        nodeStop6.addDestination(nodeStop6b);
        nodeStop6b.addDestination(nodeStop6);

        nodeStop7.addDestination(nodeStop7b);
        nodeStop7b.addDestination(nodeStop7);

        nodeList.add(J4Start);
        nodeList.add(nodeCb);
        nodeList.add(nodeDb);
        nodeList.add(nodeStop1b);
        nodeList.add(nodeFb);
        nodeList.add(nodePb);
        nodeList.add(nodeStop2b);
        nodeList.add(nodeSb);
        nodeList.add(nodeTb);
        nodeList.add(nodeZb);
        nodeList.add(nodeStop3b);
        nodeList.add(nodeDFb);
        nodeList.add(nodeAWb);
        nodeList.add(nodeAXb);
        nodeList.add(nodeStop4b);
        nodeList.add(nodeAYb);
        nodeList.add(nodeBDb);
        nodeList.add(nodeBEb);
        nodeList.add(nodeAOb);
        nodeList.add(nodeStop5b);
        nodeList.add(nodeANb);
        nodeList.add(nodeAMb);
        nodeList.add(nodeALb);
        nodeList.add(nodeStop6b);
        nodeList.add(nodeAKb);
        nodeList.add(nodeAGb);
        nodeList.add(nodeAJb);
        nodeList.add(nodeStop7b);
        nodeList.add(J4End);


        graph.addNode(J4Start);
        graph.addNode(nodeCb);
        graph.addNode(nodeDb);
        graph.addNode(nodeStop3b);
        graph.addNode(nodeFb);
        graph.addNode(nodePb);
        graph.addNode(nodeStop2b);
        graph.addNode(nodeSb);
        graph.addNode(nodeTb);
        graph.addNode(nodeZb);
        graph.addNode(nodeStop3b);
        graph.addNode(nodeDFb);
        graph.addNode(nodeAWb);
        graph.addNode(nodeAXb);
        graph.addNode(nodeStop4b);
        graph.addNode(nodeAYb);
        graph.addNode(nodeBDb);
        graph.addNode(nodeBEb);
        graph.addNode(nodeAOb);
        graph.addNode(nodeStop5b);
        graph.addNode(nodeANb);
        graph.addNode(nodeAMb);
        graph.addNode(nodeALb);
        graph.addNode(nodeStop6b);
        graph.addNode(nodeAKb);
        graph.addNode(nodeAGb);
        graph.addNode(nodeAJb);
        graph.addNode(nodeStop7b);
        graph.addNode(J4End);

        j4Route = new ArrayList<>();

        j4Route.add(J4Start);
        j4Route.add(nodeCb);
        j4Route.add(nodeDb);
        j4Route.add(nodeStop1b);
        j4Route.add(nodeFb);
        j4Route.add(nodePb);
        j4Route.add(nodeStop2b);
        j4Route.add(nodeSb);
        j4Route.add(nodeTb);
        j4Route.add(nodeZb);
        j4Route.add(nodeStop3b);
        j4Route.add(nodeDFb);
        j4Route.add(nodeAWb);
        j4Route.add(nodeAXb);
        j4Route.add(nodeStop4b);
        j4Route.add(nodeAYb);
        j4Route.add(nodeBDb);
        j4Route.add(nodeBEb);
        j4Route.add(nodeAOb);
        j4Route.add(nodeStop5b);
        j4Route.add(nodeANb);
        j4Route.add(nodeAMb);
        j4Route.add(nodeALb);
        j4Route.add(nodeStop6b);
        j4Route.add(nodeAKb);
        j4Route.add(nodeAGb);
        j4Route.add(nodeAJb);
        j4Route.add(nodeStop7b);
        j4Route.add(J4End);

        //Mapping W31 Route

        Node W31Start = new Node("W31Start",Commons.BOARD_WIDTH+200,nodeBI.getY(),Bus.transportType);
        Node nodeBIb = new Node("BIb",nodeBI.getX(),nodeBI.getY(),Bus.transportType);
        Node nodeStop8b = new Node("Stop8b",nodeStop8.getX(),nodeStop8.getY(),Bus.transportType,true);
        Node nodeBHb = new Node("BHb",nodeBH.getX(),nodeBH.getY(),Bus.transportType);
        Node nodeBPb = new Node("BPb",nodeBP.getX(),nodeBP.getY(),Bus.transportType);
        Node nodeStop9b = new Node("Stop9b",nodeStop9.getX(),nodeStop9.getY(),Bus.transportType,true);
        Node nodeBRb = new Node("BRb",nodeBR.getX(),nodeBR.getY(),Bus.transportType);
        Node nodeCAb = new Node("CAb",nodeCA.getX(),nodeCA.getY(),Bus.transportType);
        Node nodeBXb = new Node("BXb",nodeBX.getX(),nodeBX.getY(),Bus.transportType);
        Node nodeCJb = new Node("CJb",nodeCJ.getX(),nodeCJ.getY(),Bus.transportType);
        Node nodeStop10b = new Node("Stop10b",nodeStop10.getX(),nodeStop10.getY(),Bus.transportType,true);
        Node nodeCIb = new Node("CIb",nodeCI.getX(),nodeCI.getY(),Bus.transportType);
        Node nodeCGb = new Node("CGb",nodeCG.getX(),nodeCG.getY(),Bus.transportType);
        Node nodeCSb = new Node("CSb",nodeCS.getX(),nodeCS.getY(),Bus.transportType);
        Node nodeStop11b = new Node("Stop11b",nodeStop11.getX(),nodeStop11.getY(),Bus.transportType,true);
        Node nodeCTb = new Node("CTb",nodeCT.getX(),nodeCT.getY(),Bus.transportType);
        Node nodeCXb = new Node("CXb",nodeCX.getX(),nodeCX.getY(),Bus.transportType);
        Node nodeStop12b = new Node("Stop12b",nodeStop12.getX(),nodeStop12.getY(),Bus.transportType,true);
        Node nodeCZb = new Node("CZb",nodeCZ.getX(),nodeCZ.getY(),Bus.transportType);
        Node nodeDBb = new Node("DBb",nodeDB.getX(),nodeDB.getY(),Bus.transportType);
        Node nodeStop13b = new Node("Stop13b",nodeStop13.getX(),nodeStop13.getY(),Bus.transportType,true);
        Node nodeDCb = new Node("DCb",nodeDC.getX(),nodeDC.getY(),Bus.transportType);
        Node W31End = new Node("W31End",nodeDC.getX(),-300,Bus.transportType);

        W31Start.addDestination(nodeBIb);

        nodeBIb.addDestination(W31Start);
        nodeBIb.addDestination(nodeStop8b);

        nodeStop8b.addDestination(nodeBIb);
        nodeStop8b.addDestination(nodeBHb);

        nodeBHb.addDestination(nodeStop8b);
        nodeBHb.addDestination(nodeBPb);

        nodeBPb.addDestination(nodeBHb);
        nodeBPb.addDestination(nodeStop9b);

        nodeStop9b.addDestination(nodeBPb);
        nodeStop9b.addDestination(nodeBRb);

        nodeBRb.addDestination(nodeStop9b);
        nodeBRb.addDestination(nodeCAb);

        nodeCAb.addDestination(nodeBRb);
        nodeCAb.addDestination(nodeBXb);

        nodeBXb.addDestination(nodeCAb);
        nodeBXb.addDestination(nodeCJb);

        nodeCJb.addDestination(nodeBXb);
        nodeCJb.addDestination(nodeStop10b);

        nodeStop10b.addDestination(nodeCJb);
        nodeStop10b.addDestination(nodeCIb);

        nodeCIb.addDestination(nodeStop10b);
        nodeCIb.addDestination(nodeCGb);

        nodeCGb.addDestination(nodeCIb);
        nodeCGb.addDestination(nodeCSb);

        nodeCSb.addDestination(nodeCGb);
        nodeCSb.addDestination(nodeStop11b);

        nodeStop11b.addDestination(nodeCSb);
        nodeStop11b.addDestination(nodeCSb);

        nodeCTb.addDestination(nodeStop11b);
        nodeCTb.addDestination(nodeCXb);

        nodeCXb.addDestination(nodeCTb);
        nodeCXb.addDestination(nodeStop12b);

        nodeStop12b.addDestination(nodeCXb);
        nodeStop12b.addDestination(nodeCZb);

        nodeCZb.addDestination(nodeStop12b);
        nodeCZb.addDestination(nodeDBb);

        nodeDBb.addDestination(nodeCZb);
        nodeDBb.addDestination(nodeStop13b);

        nodeStop13b.addDestination(nodeDBb);
        nodeStop13b.addDestination(nodeDCb);

        nodeDCb.addDestination(nodeStop13b);
        nodeDCb.addDestination(W31End);

        W31End.addDestination(nodeDCb);

        nodeStop8.addDestination(nodeStop8b);
        nodeStop8b.addDestination(nodeStop8);

        nodeStop9.addDestination(nodeStop9b);
        nodeStop9b.addDestination(nodeStop9);

        nodeStop10.addDestination(nodeStop10b);
        nodeStop10b.addDestination(nodeStop10);

        nodeStop11.addDestination(nodeStop11b);
        nodeStop11b.addDestination(nodeStop11);

        nodeStop12.addDestination(nodeStop12b);
        nodeStop12b.addDestination(nodeStop12);

        nodeStop13.addDestination(nodeStop13b);
        nodeStop13b.addDestination(nodeStop13);

        nodeList.add(W31Start);
        nodeList.add(nodeBIb);
        nodeList.add(nodeStop8b);
        nodeList.add(nodeBHb);
        nodeList.add(nodeBPb);
        nodeList.add(nodeStop9b);
        nodeList.add(nodeBRb);
        nodeList.add(nodeCAb);
        nodeList.add(nodeBXb);
        nodeList.add(nodeCJb);
        nodeList.add(nodeStop10b);
        nodeList.add(nodeCIb);
        nodeList.add(nodeCGb);
        nodeList.add(nodeCSb);
        nodeList.add(nodeStop11b);
        nodeList.add(nodeCTb);
        nodeList.add(nodeCXb);
        nodeList.add(nodeStop12b);
        nodeList.add(nodeCZb);
        nodeList.add(nodeDBb);
        nodeList.add(nodeStop13b);
        nodeList.add(nodeDCb);
        nodeList.add(W31End);

        graph.addNode(W31Start);
        graph.addNode(nodeBIb);
        graph.addNode(nodeStop8b);
        graph.addNode(nodeBHb);
        graph.addNode(nodeBPb);
        graph.addNode(nodeStop9b);
        graph.addNode(nodeBRb);
        graph.addNode(nodeCAb);
        graph.addNode(nodeBXb);
        graph.addNode(nodeCJb);
        graph.addNode(nodeStop10b);
        graph.addNode(nodeCIb);
        graph.addNode(nodeCGb);
        graph.addNode(nodeCSb);
        graph.addNode(nodeStop11b);
        graph.addNode(nodeCTb);
        graph.addNode(nodeCXb);
        graph.addNode(nodeStop12b);
        graph.addNode(nodeCZb);
        graph.addNode(nodeDBb);
        graph.addNode(nodeStop13b);
        graph.addNode(nodeDCb);
        graph.addNode(W31End);

        w31Route = new ArrayList<>();

        w31Route.add(W31Start);
        w31Route.add(nodeBIb);
        w31Route.add(nodeStop8b);
        w31Route.add(nodeBHb);
        w31Route.add(nodeBPb);
        w31Route.add(nodeStop9b);
        w31Route.add(nodeBRb);
        w31Route.add(nodeCAb);
        w31Route.add(nodeBXb);
        w31Route.add(nodeCJb);
        w31Route.add(nodeStop10b);
        w31Route.add(nodeCIb);
        w31Route.add(nodeCGb);
        w31Route.add(nodeCSb);
        w31Route.add(nodeStop11b);
        w31Route.add(nodeCTb);
        w31Route.add(nodeCXb);
        w31Route.add(nodeStop12b);
        w31Route.add(nodeCZb);
        w31Route.add(nodeDBb);
        w31Route.add(nodeStop13b);
        w31Route.add(nodeDCb);
        w31Route.add(W31End);

        //Bike Paths
        Node nodeAk = new Node("Ak", nodeA.getX(), nodeA.getY(), Bike.transportType);
        Node nodeBk = new Node("Bk", nodeB.getX(), nodeB.getY(), Bike.transportType);
        Node nodeCk = new Node("Ck", nodeC.getX(), nodeC.getY(), Bike.transportType);
        Node nodeDk = new Node("Dk", nodeD.getX(), nodeD.getY(), Bike.transportType);
        Node nodeEk = new Node("Ek", nodeE.getX(), nodeE.getY(), Bike.transportType);
        Node nodeFk = new Node("Fk", nodeF.getX(), nodeF.getY(), Bike.transportType);
        Node nodeGk = new Node("Gk", nodeG.getX(), nodeG.getY(), Bike.transportType);
        Node nodeHk = new Node("Hk", nodeH.getX(), nodeH.getY(), Bike.transportType);
        Node nodeIk = new Node("Ik", nodeI.getX(), nodeI.getY(), Bike.transportType);
        Node nodeJk = new Node("Jk", nodeJ.getX(), nodeJ.getY(), Bike.transportType);
        Node nodeKk = new Node("Kk", nodeK.getX(), nodeK.getY(), Bike.transportType);
        Node nodeLk = new Node("Lk", nodeL.getX(), nodeL.getY(), Bike.transportType);
        Node nodeMk = new Node("Mk", nodeM.getX(), nodeM.getY(), Bike.transportType);
        Node nodeNk = new Node("Nk", nodeN.getX(), nodeN.getY(), Bike.transportType);
        Node nodeOk = new Node("Ok", nodeO.getX(), nodeO.getY(), Bike.transportType);
        Node nodePk = new Node("Pk", nodeP.getX(), nodeP.getY(), Bike.transportType);
        Node nodeQk = new Node("Qk", nodeQ.getX(), nodeQ.getY(), Bike.transportType);
        Node nodeRk = new Node("Rk", nodeR.getX(), nodeR.getY(), Bike.transportType);
        Node nodeSk = new Node("Sk", nodeS.getX(), nodeS.getY(), Bike.transportType);
        Node nodeTk = new Node("Tk", nodeT.getX(), nodeT.getY(), Bike.transportType);
        Node nodeUk = new Node("Uk", nodeU.getX(), nodeU.getY(), Bike.transportType);
        Node nodeVk = new Node("Vk", nodeV.getX(), nodeV.getY(), Bike.transportType);
        Node nodeWk = new Node("Wk", nodeW.getX(), nodeW.getY(), Bike.transportType);
        Node nodeXk = new Node("Xk", nodeX.getX(), nodeX.getY(), Bike.transportType);
        Node nodeYk = new Node("Yk", nodeY.getX(), nodeY.getY(), Bike.transportType);
        Node nodeZk = new Node("Zk", nodeZ.getX(), nodeZ.getY(), Bike.transportType);
        Node nodeAAk = new Node("AAk", nodeAA.getX(), nodeAA.getY(), Bike.transportType);
        Node nodeABk = new Node("ABk", nodeAB.getX(), nodeAB.getY(), Bike.transportType);
        Node nodeACk = new Node("ACk", nodeAC.getX(), nodeAC.getY(), Bike.transportType);
        Node nodeADk = new Node("ADk", nodeAD.getX(), nodeAD.getY(), Bike.transportType);
        Node nodeAEk = new Node("AEk", nodeAE.getX(), nodeAE.getY(), Bike.transportType);
        Node nodeAFk = new Node("AFk", nodeAF.getX(), nodeAF.getY(), Bike.transportType);
        Node nodeAGk = new Node("AGk", nodeAG.getX(), nodeAG.getY(), Bike.transportType);
        Node nodeAHk = new Node("AHk", nodeAH.getX(), nodeAH.getY(), Bike.transportType);
        Node nodeAIk = new Node("AIk", nodeAI.getX(), nodeAI.getY(), Bike.transportType);
        Node nodeAJk = new Node("AJk", nodeAJ.getX(), nodeAJ.getY(), Bike.transportType);
        Node nodeAKk = new Node("AKk", nodeAK.getX(), nodeAK.getY(), Bike.transportType);
        Node nodeALk = new Node("ALk", nodeAL.getX(), nodeAL.getY(), Bike.transportType);
        Node nodeAMk = new Node("AMk", nodeAM.getX(), nodeAM.getY(), Bike.transportType);
        Node nodeANk = new Node("ANk", nodeAN.getX(), nodeAN.getY(), Bike.transportType);
        Node nodeAOk = new Node("AOk", nodeAO.getX(), nodeAO.getY(), Bike.transportType);
        Node nodeAPk = new Node("APk", nodeAP.getX(), nodeAP.getY(), Bike.transportType);
        Node nodeAQk = new Node("AQk", nodeAQ.getX(), nodeAQ.getY(), Bike.transportType);
        Node nodeARk = new Node("ARk", nodeAR.getX(), nodeAR.getY(), Bike.transportType);
        Node nodeASk = new Node("ASk", nodeAS.getX(), nodeAS.getY(), Bike.transportType);
        Node nodeATk = new Node("ATk", nodeAT.getX(), nodeAT.getY(), Bike.transportType);
        Node nodeAUk = new Node("AUk", nodeAU.getX(), nodeAU.getY(), Bike.transportType);
        Node nodeAVk = new Node("AVk", nodeAV.getX(), nodeAV.getY(), Bike.transportType);
        Node nodeAWk = new Node("AWk", nodeAW.getX(), nodeAW.getY(), Bike.transportType);
        Node nodeAXk = new Node("AXk", nodeAX.getX(), nodeAX.getY(), Bike.transportType);
        Node nodeAYk = new Node("AYk", nodeAY.getX(), nodeAY.getY(), Bike.transportType);
        Node nodeAZk = new Node("AZk", nodeAZ.getX(), nodeAZ.getY(), Bike.transportType);
        Node nodeBAk = new Node("BAk", nodeBA.getX(), nodeBA.getY(), Bike.transportType);
        Node nodeBBk = new Node("BBk", nodeBB.getX(), nodeBB.getY(), Bike.transportType);
        Node nodeBCk = new Node("BCk", nodeBC.getX(), nodeBC.getY(), Bike.transportType);
        Node nodeBDk = new Node("BDk", nodeBD.getX(), nodeBD.getY(), Bike.transportType);
        Node nodeBEk = new Node("BEk", nodeBE.getX(), nodeBE.getY(), Bike.transportType);
        Node nodeBFk = new Node("BFk", nodeBF.getX(), nodeBF.getY(), Bike.transportType);
        Node nodeBGk = new Node("BGk", nodeBG.getX(), nodeBG.getY(), Bike.transportType);
        Node nodeBHk = new Node("BHk", nodeBH.getX(), nodeBH.getY(), Bike.transportType);
        Node nodeBIk = new Node("BIk", nodeBI.getX(), nodeBI.getY(), Bike.transportType);
        Node nodeBJk = new Node("BJk", nodeBJ.getX(), nodeBJ.getY(), Bike.transportType);
        Node nodeBKk = new Node("BKk", nodeBK.getX(), nodeBK.getY(), Bike.transportType);
        Node nodeBLk = new Node("BLk", nodeBL.getX(), nodeBL.getY(), Bike.transportType);
        Node nodeBMk = new Node("BMk", nodeBM.getX(), nodeBM.getY(), Bike.transportType);
        Node nodeBNk = new Node("BNk", nodeBN.getX(), nodeBN.getY(), Bike.transportType);
        Node nodeBOk = new Node("BOk", nodeBO.getX(), nodeBO.getY(), Bike.transportType);
        Node nodeBPk = new Node("BPk", nodeBP.getX(), nodeBP.getY(), Bike.transportType);
        Node nodeBQk = new Node("BQk", nodeBQ.getX(), nodeBQ.getY(), Bike.transportType);
        Node nodeBRk = new Node("BRk", nodeBR.getX(), nodeBR.getY(), Bike.transportType);
        Node nodeBSk = new Node("BSk", nodeBS.getX(), nodeBS.getY(), Bike.transportType);
        Node nodeBTk = new Node("BTk", nodeBT.getX(), nodeBT.getY(), Bike.transportType);
        Node nodeBUk = new Node("BUk", nodeBU.getX(), nodeBU.getY(), Bike.transportType);
        Node nodeBVk = new Node("BVk", nodeBV.getX(), nodeBV.getY(), Bike.transportType);
        Node nodeBWk = new Node("BWk", nodeBW.getX(), nodeBW.getY(), Bike.transportType);
        Node nodeBXk = new Node("BXk", nodeBX.getX(), nodeBX.getY(), Bike.transportType);
        Node nodeBYk = new Node("BYk", nodeBY.getX(), nodeBY.getY(), Bike.transportType);
        Node nodeBZk = new Node("BZk", nodeBZ.getX(), nodeBZ.getY(), Bike.transportType);
        Node nodeCAk = new Node("CAk", nodeCA.getX(), nodeCA.getY(), Bike.transportType);
        Node nodeCBk = new Node("CBk", nodeCB.getX(), nodeCB.getY(), Bike.transportType);
        Node nodeCCk = new Node("CCk", nodeCC.getX(), nodeCC.getY(), Bike.transportType);
        Node nodeCDk = new Node("CDk", nodeCD.getX(), nodeCD.getY(), Bike.transportType);
        Node nodeCEk = new Node("CEk", nodeCE.getX(), nodeCE.getY(), Bike.transportType);
        Node nodeCFk = new Node("CFk", nodeCF.getX(), nodeCF.getY(), Bike.transportType);
        Node nodeCGk = new Node("CGk", nodeCG.getX(), nodeCG.getY(), Bike.transportType);
        Node nodeCHk = new Node("CHk", nodeCH.getX(), nodeCH.getY(), Bike.transportType);
        Node nodeCIk = new Node("CIk", nodeCI.getX(), nodeCI.getY(), Bike.transportType);
        Node nodeCJk = new Node("CJk", nodeCJ.getX(), nodeCJ.getY(), Bike.transportType);
        Node nodeCKk = new Node("CKk", nodeCK.getX(), nodeCK.getY(), Bike.transportType);
        Node nodeCLk = new Node("CLk", nodeCL.getX(), nodeCL.getY(), Bike.transportType);
        Node nodeCMk = new Node("CMk", nodeCM.getX(), nodeCM.getY(), Bike.transportType);
        Node nodeCNk = new Node("CNk", nodeCN.getX(), nodeCN.getY(), Bike.transportType);
        Node nodeCOk = new Node("COk", nodeCO.getX(), nodeCO.getY(), Bike.transportType);
        Node nodeCPk = new Node("CPk", nodeCP.getX(), nodeCP.getY(), Bike.transportType);
        Node nodeCQk = new Node("CQk", nodeCQ.getX(), nodeCQ.getY(), Bike.transportType);
        Node nodeCRk = new Node("CRk", nodeCR.getX(), nodeCR.getY(), Bike.transportType);
        Node nodeCSk = new Node("CSk", nodeCS.getX(), nodeCS.getY(), Bike.transportType);
        Node nodeCTk = new Node("CTk", nodeCT.getX(), nodeCT.getY(), Bike.transportType);
        Node nodeCUk = new Node("CUk", nodeCU.getX(), nodeCU.getY(), Bike.transportType);
        Node nodeCVk = new Node("CVk", nodeCV.getX(), nodeCV.getY(), Bike.transportType);
        Node nodeCXk = new Node("CXk", nodeCX.getX(), nodeCX.getY(), Bike.transportType);
        Node nodeCYk = new Node("CYk", nodeCY.getX(), nodeCY.getY(), Bike.transportType);
        Node nodeCZk = new Node("CZk", nodeCZ.getX(), nodeCZ.getY(), Bike.transportType);
        Node nodeDAk = new Node("DAk", nodeDA.getX(), nodeDA.getY(), Bike.transportType);
        Node nodeDBk = new Node("DBk", nodeDB.getX(), nodeDB.getY(), Bike.transportType);
        Node nodeDCk = new Node("DCk", nodeDC.getX(), nodeDC.getY(), Bike.transportType);
        Node nodeDDk = new Node("DDk", nodeDD.getX(), nodeDD.getY(), Bike.transportType);
        Node nodeDFk = new Node("DFk", nodeDF.getX(), nodeDF.getY(), Bike.transportType);
        Node nodeStop1k = new Node("Stop1k", nodeStop1.getX(), nodeStop1.getY(), Bike.transportType);
        Node nodeStop2k = new Node("Stop2k", nodeStop2.getX(), nodeStop2.getY(), Bike.transportType);
        Node nodeStop3k = new Node("Stop3k", nodeStop3.getX(), nodeStop3.getY(), Bike.transportType);
        Node nodeStop4k = new Node("Stop4k", nodeStop4.getX(), nodeStop4.getY(), Bike.transportType);
        Node nodeStop5k = new Node("Stop5k", nodeStop5.getX(), nodeStop5.getY(), Bike.transportType);
        Node nodeStop6k = new Node("Stop6k", nodeStop6.getX(), nodeStop6.getY(), Bike.transportType);
        Node nodeStop7k = new Node("Stop7k", nodeStop7.getX(), nodeStop7.getY(), Bike.transportType);
        Node nodeStop8k = new Node("Stop8k", nodeStop8.getX(), nodeStop8.getY(), Bike.transportType);
        Node nodeStop9k = new Node("Stop9k", nodeStop9.getX(), nodeStop9.getY(), Bike.transportType);
        Node nodeStop10k = new Node("Stop10k", nodeStop10.getX(), nodeStop10.getY(), Bike.transportType);
        Node nodeStop11k = new Node("Stop11k", nodeStop11.getX(), nodeStop11.getY(), Bike.transportType);
        Node nodeStop12k = new Node("Stop12k", nodeStop12.getX(), nodeStop12.getY(), Bike.transportType);
        Node nodeStop13k = new Node("Stop13k", nodeStop13.getX(), nodeStop13.getY(), Bike.transportType);
        Node nodeBStop1k = new Node("BStop1k", nodeBStop1.getX(), nodeBStop1.getY(), Bike.transportType,true);
        Node nodeBStop2k = new Node("BStop2k", nodeBStop2.getX(), nodeBStop2.getY(), Bike.transportType,true);
        Node nodeBStop3k = new Node("BStop3k", nodeBStop3.getX(), nodeBStop3.getY(), Bike.transportType,true);
        Node nodeBStop4k = new Node("BStop4k", nodeBStop4.getX(), nodeBStop4.getY(), Bike.transportType,true);
        Node nodeBStop5k = new Node("BStop5k", nodeBStop5.getX(), nodeBStop5.getY(), Bike.transportType,true);
        Node nodeBStop6k = new Node("BStop6k", nodeBStop6.getX(), nodeBStop6.getY(), Bike.transportType,true);
        Node nodeBStop7k = new Node("BStop7k", nodeBStop7.getX(), nodeBStop7.getY(), Bike.transportType,true);

        nodeAk.addDestination(nodeBk);

        nodeBk.addDestination(nodeAk);
        nodeBk.addDestination(nodeCk);
        nodeBk.addDestination(nodeEk);

        nodeCk.addDestination(nodeBk);
        nodeCk.addDestination(nodeDk);

        nodeDk.addDestination(nodeCk);
        nodeDk.addDestination(nodeEk);
        nodeDk.addDestination(nodeStop1k);

        nodeEk.addDestination(nodeBk);
        nodeEk.addDestination(nodeDk);
        nodeEk.addDestination(nodeHk);
        nodeEk.addDestination(nodeBStop1k);

        nodeFk.addDestination(nodeStop1k);
        nodeFk.addDestination(nodeGk);
        nodeFk.addDestination(nodeNk);

        nodeGk.addDestination(nodeFk);
        nodeGk.addDestination(nodeIk);
        nodeGk.addDestination(nodeMk);

        nodeHk.addDestination(nodeEk);
        nodeHk.addDestination(nodeIk);
        nodeHk.addDestination(nodeJk);
        nodeHk.addDestination(nodeKk);

        nodeIk.addDestination(nodeGk);
        nodeIk.addDestination(nodeHk);

        nodeJk.addDestination(nodeHk);
        nodeJk.addDestination(nodeADk);
        nodeJk.addDestination(nodeAFk);

        nodeKk.addDestination(nodeHk);
        nodeKk.addDestination(nodeLk);
        nodeKk.addDestination(nodeADk);

        nodeLk.addDestination(nodeKk);
        nodeLk.addDestination(nodeMk);
        nodeLk.addDestination(nodeAAk);

        nodeMk.addDestination(nodeGk);
        nodeMk.addDestination(nodeLk);
        nodeMk.addDestination(nodeABk);

        nodeNk.addDestination(nodeFk);
        nodeNk.addDestination(nodeOk);
        nodeNk.addDestination(nodePk);

        nodeOk.addDestination(nodeNk);

        nodePk.addDestination(nodeNk);
        nodePk.addDestination(nodeQk);
        nodePk.addDestination(nodeStop2k);

        nodeQk.addDestination(nodePk);
        nodeQk.addDestination(nodeWk);
        nodeQk.addDestination(nodeXk);

        nodeRk.addDestination(nodeXk);
        nodeRk.addDestination(nodeYk);
        nodeRk.addDestination(nodeABk);

        nodeSk.addDestination(nodeStop2k);
        nodeSk.addDestination(nodeTk);
        nodeSk.addDestination(nodeVk);

        nodeTk.addDestination(nodeSk);
        nodeTk.addDestination(nodeUk);
        nodeTk.addDestination(nodeBStop4k);

        nodeUk.addDestination(nodeTk);
        nodeUk.addDestination(nodeVk);
        nodeUk.addDestination(nodeZk);

        nodeVk.addDestination(nodeSk);
        nodeVk.addDestination(nodeUk);
        nodeVk.addDestination(nodeWk);

        nodeWk.addDestination(nodeQk);
        nodeWk.addDestination(nodeVk);
        nodeWk.addDestination(nodeYk);

        nodeXk.addDestination(nodeQk);
        nodeXk.addDestination(nodeRk);

        nodeYk.addDestination(nodeRk);
        nodeYk.addDestination(nodeWk);
        nodeYk.addDestination(nodeZk);

        nodeZk.addDestination(nodeUk);
        nodeZk.addDestination(nodeYk);
        nodeZk.addDestination(nodeAQk);
        nodeZk.addDestination(nodeStop3k);

        nodeAAk.addDestination(nodeLk);
        nodeAAk.addDestination(nodeABk);
        nodeAAk.addDestination(nodeACk);
        nodeAAk.addDestination(nodeBStop3k);

        nodeABk.addDestination(nodeMk);
        nodeABk.addDestination(nodeRk);
        nodeABk.addDestination(nodeAAk);

        nodeACk.addDestination(nodeAAk);
        nodeACk.addDestination(nodeADk);

        nodeADk.addDestination(nodeJk);
        nodeADk.addDestination(nodeKk);
        nodeADk.addDestination(nodeACk);
        nodeADk.addDestination(nodeAEk);

        nodeAEk.addDestination(nodeADk);
        nodeAEk.addDestination(nodeAFk);
        nodeAEk.addDestination(nodeBStop2k);

        nodeAFk.addDestination(nodeJk);
        nodeAFk.addDestination(nodeAEk);
        nodeAFk.addDestination(nodeAGk);
        nodeAFk.addDestination(nodeAKk);
        nodeAFk.addDestination(nodeDDk);

        nodeAGk.addDestination(nodeBStop1k);
        nodeAGk.addDestination(nodeAFk);
        nodeAGk.addDestination(nodeAHk);
        nodeAGk.addDestination(nodeAJk);

        nodeAHk.addDestination(nodeAGk);
        nodeAHk.addDestination(nodeAIk);

        nodeAIk.addDestination(nodeAHk);
        nodeAIk.addDestination(nodeAJk);

        nodeAJk.addDestination(nodeDDk);
        nodeAJk.addDestination(nodeAJk);
        nodeAJk.addDestination(nodeStop7k);

        nodeAKk.addDestination(nodeAFk);
        nodeAKk.addDestination(nodeStop6k);
        nodeAKk.addDestination(nodeCMk);

        nodeALk.addDestination(nodeStop6k);
        nodeALk.addDestination(nodeAMk);
        nodeALk.addDestination(nodeCLk);

        nodeAMk.addDestination(nodeALk);
        nodeAMk.addDestination(nodeANk);
        nodeAMk.addDestination(nodeCKk);

        nodeANk.addDestination(nodeBStop2k);
        nodeANk.addDestination(nodeAMk);
        nodeANk.addDestination(nodeStop5k);
        nodeANk.addDestination(nodeBYk);

        nodeAOk.addDestination(nodeStop5k);
        nodeAOk.addDestination(nodeAPk);
        nodeAOk.addDestination(nodeBEk);

        nodeAPk.addDestination(nodeAOk);
        nodeAPk.addDestination(nodeAQk);
        nodeAPk.addDestination(nodeBDk);

        nodeAQk.addDestination(nodeZk);
        nodeAQk.addDestination(nodeBStop3k);
        nodeAQk.addDestination(nodeAPk);

        nodeAQk.addDestination(nodeZk);
        nodeAQk.addDestination(nodeAAk);
        nodeAQk.addDestination(nodeAPk);

        nodeARk.addDestination(nodeBStop4k);
        nodeARk.addDestination(nodeASk);
        nodeARk.addDestination(nodeDFk);

        nodeASk.addDestination(nodeARk);
        nodeASk.addDestination(nodeATk);
        nodeASk.addDestination(nodeAVk);

        nodeATk.addDestination(nodeASk);
        nodeATk.addDestination(nodeAUk);

        nodeAUk.addDestination(nodeATk);

        nodeAVk.addDestination(nodeASk);

        nodeAWk.addDestination(nodeAXk);
        nodeAWk.addDestination(nodeBStop5k);
        nodeAWk.addDestination(nodeDFk);

        nodeAXk.addDestination(nodeAWk);
        nodeAXk.addDestination(nodeStop4k);
        nodeAXk.addDestination(nodeBGk);

        nodeAYk.addDestination(nodeStop4k);
        nodeAYk.addDestination(nodeAZk);
        nodeAYk.addDestination(nodeBDk);

        nodeAZk.addDestination(nodeAYk);
        nodeAZk.addDestination(nodeBAk);
        nodeAZk.addDestination(nodeBCk);

        nodeBAk.addDestination(nodeAZk);
        nodeBAk.addDestination(nodeBBk);

        nodeBBk.addDestination(nodeBAk);

        nodeBCk.addDestination(nodeAZk);

        nodeBDk.addDestination(nodeAPk);
        nodeBDk.addDestination(nodeAYk);
        nodeBDk.addDestination(nodeBEk);

        nodeBEk.addDestination(nodeAOk);
        nodeBEk.addDestination(nodeBDk);
        nodeBEk.addDestination(nodeBFk);
        nodeBEk.addDestination(nodeBUk);

        nodeBFk.addDestination(nodeBEk);
        nodeBFk.addDestination(nodeBGk);
        nodeBFk.addDestination(nodeBQk);

        nodeBGk.addDestination(nodeAXk);
        nodeBGk.addDestination(nodeBFk);
        nodeBGk.addDestination(nodeBHk);

        nodeBHk.addDestination(nodeBGk);
        nodeBHk.addDestination(nodeStop8k);
        nodeBHk.addDestination(nodeBPk);

        nodeBIk.addDestination(nodeStop8k);
        nodeBIk.addDestination(nodeBJk);

        nodeBJk.addDestination(nodeBStop5k);
        nodeBJk.addDestination(nodeBIk);
        nodeBJk.addDestination(nodeBKk);

        nodeBKk.addDestination(nodeBJk);
        nodeBKk.addDestination(nodeBLk);
        nodeBKk.addDestination(nodeBMk);

        nodeBLk.addDestination(nodeBKk);

        nodeBMk.addDestination(nodeBKk);
        nodeBMk.addDestination(nodeBNk);
        nodeBMk.addDestination(nodeBOk);

        nodeBNk.addDestination(nodeBMk);

        nodeBOk.addDestination(nodeBMk);

        nodeBPk.addDestination(nodeBHk);
        nodeBPk.addDestination(nodeStop9k);

        nodeBQk.addDestination(nodeBFk);
        nodeBQk.addDestination(nodeBRk);
        nodeBQk.addDestination(nodeBSk);

        nodeBRk.addDestination(nodeStop9k);
        nodeBRk.addDestination(nodeBQk);
        nodeBRk.addDestination(nodeCAk);

        nodeBSk.addDestination(nodeBQk);
        nodeBSk.addDestination(nodeBTk);
        nodeBSk.addDestination(nodeBUk);

        nodeBTk.addDestination(nodeBSk);

        nodeBUk.addDestination(nodeBEk);
        nodeBUk.addDestination(nodeBSk);
        nodeBUk.addDestination(nodeBVk);

        nodeBVk.addDestination(nodeBUk);
        nodeBVk.addDestination(nodeBWk);

        nodeBWk.addDestination(nodeBVk);
        nodeBWk.addDestination(nodeBXk);
        nodeBWk.addDestination(nodeBYk);

        nodeBXk.addDestination(nodeBWk);
        nodeBXk.addDestination(nodeBZk);
        nodeBXk.addDestination(nodeCAk);

        nodeBYk.addDestination(nodeANk);
        nodeBYk.addDestination(nodeBWk);
        nodeBYk.addDestination(nodeBZk);

        nodeBZk.addDestination(nodeBXk);
        nodeBZk.addDestination(nodeBZk);
        nodeBZk.addDestination(nodeCJk);

        nodeCAk.addDestination(nodeBRk);
        nodeCAk.addDestination(nodeBXk);
        nodeCAk.addDestination(nodeCBk);
        nodeCAk.addDestination(nodeCFk);

        nodeCBk.addDestination(nodeCAk);
        nodeCBk.addDestination(nodeCCk);

        nodeCCk.addDestination(nodeCBk);
        nodeCCk.addDestination(nodeCDk);
        nodeCCk.addDestination(nodeCEk);
        nodeCCk.addDestination(nodeBStop6k);

        nodeCDk.addDestination(nodeCCk);

        nodeCEk.addDestination(nodeCCk);

        nodeCFk.addDestination(nodeCAk);
        nodeCFk.addDestination(nodeBStop6k);
        nodeCFk.addDestination(nodeCGk);

        nodeCGk.addDestination(nodeCFk);
        nodeCGk.addDestination(nodeCHk);
        nodeCGk.addDestination(nodeCIk);
        nodeCGk.addDestination(nodeCSk);

        nodeCHk.addDestination(nodeCGk);
        nodeCHk.addDestination(nodeCTk);
        nodeCHk.addDestination(nodeCVk);
        nodeCHk.addDestination(nodeCXk);

        nodeCIk.addDestination(nodeCGk);
        nodeCIk.addDestination(nodeStop10k);
        nodeCIk.addDestination(nodeCLk);
        nodeCIk.addDestination(nodeCNk);

        nodeCJk.addDestination(nodeBZk);
        nodeCJk.addDestination(nodeStop10k);
        nodeCJk.addDestination(nodeCKk);

        nodeCKk.addDestination(nodeAMk);
        nodeCKk.addDestination(nodeCJk);
        nodeCKk.addDestination(nodeCLk);

        nodeCLk.addDestination(nodeALk);
        nodeCLk.addDestination(nodeCIk);
        nodeCLk.addDestination(nodeCKk);

        nodeCMk.addDestination(nodeAKk);
        nodeCMk.addDestination(nodeCNk);
        nodeCMk.addDestination(nodeDDk);

        nodeCNk.addDestination(nodeCIk);
        nodeCNk.addDestination(nodeCMk);
        nodeCNk.addDestination(nodeCOk);
        nodeCNk.addDestination(nodeCRk);

        nodeCOk.addDestination(nodeCNk);
        nodeCOk.addDestination(nodeCPk);
        nodeCOk.addDestination(nodeDDk);

        nodeCPk.addDestination(nodeCOk);
        nodeCPk.addDestination(nodeCQk);
        nodeCPk.addDestination(nodeCRk);

        nodeCQk.addDestination(nodeCPk);
        nodeCQk.addDestination(nodeBStop7k);

        nodeCRk.addDestination(nodeCNk);
        nodeCRk.addDestination(nodeCPk);
        nodeCRk.addDestination(nodeCSk);

        nodeCSk.addDestination(nodeCGk);
        nodeCSk.addDestination(nodeCRk);
        nodeCSk.addDestination(nodeStop11k);

        nodeCTk.addDestination(nodeCHk);
        nodeCTk.addDestination(nodeBStop7k);
        nodeCTk.addDestination(nodeStop11k);
        nodeCTk.addDestination(nodeCUk);

        nodeCUk.addDestination(nodeCTk);
        nodeCUk.addDestination(nodeCVk);

        nodeCVk.addDestination(nodeCHk);
        nodeCVk.addDestination(nodeCUk);

        nodeCXk.addDestination(nodeCHk);
        nodeCXk.addDestination(nodeCYk);
        nodeCXk.addDestination(nodeStop12k);

        nodeCYk.addDestination(nodeCXk);

        nodeCZk.addDestination(nodeStop12k);
        nodeCZk.addDestination(nodeDAk);
        nodeCZk.addDestination(nodeDBk);

        nodeDAk.addDestination(nodeCZk);

        nodeDBk.addDestination(nodeCZk);
        nodeDBk.addDestination(nodeStop13k);

        nodeDCk.addDestination(nodeStop13k);

        nodeDDk.addDestination(nodeAFk);
        nodeDDk.addDestination(nodeAJk);
        nodeDDk.addDestination(nodeCMk);
        nodeDDk.addDestination(nodeCOk);

        nodeDFk.addDestination(nodeStop3k);
        nodeDFk.addDestination(nodeARk);
        nodeDFk.addDestination(nodeAWk);

        nodeStop1k.addDestination(nodeDk);
        nodeStop1k.addDestination(nodeFk);

        nodeStop2k.addDestination(nodePk);
        nodeStop2k.addDestination(nodeSk);

        nodeStop3k.addDestination(nodeZk);
        nodeStop3k.addDestination(nodeDFk);

        nodeStop4k.addDestination(nodeAXk);
        nodeStop4k.addDestination(nodeAYk);

        nodeStop5k.addDestination(nodeANk);
        nodeStop5k.addDestination(nodeAOk);

        nodeStop6k.addDestination(nodeAKk);
        nodeStop6k.addDestination(nodeALk);

        nodeStop7k.addDestination(nodeAJk);

        nodeStop8k.addDestination(nodeBIk);
        nodeStop8k.addDestination(nodeBHk);

        nodeStop9k.addDestination(nodeBPk);
        nodeStop9k.addDestination(nodeBRk);

        nodeStop10k.addDestination(nodeCJk);
        nodeStop10k.addDestination(nodeCIk);

        nodeStop11k.addDestination(nodeCSk);
        nodeStop11k.addDestination(nodeCTk);

        nodeStop12k.addDestination(nodeCXk);
        nodeStop12k.addDestination(nodeCZk);

        nodeStop13k.addDestination(nodeDBk);
        nodeStop13k.addDestination(nodeDCk);

        nodeBStop1k.addDestination(nodeEk);
        nodeBStop1k.addDestination(nodeAGk);

        nodeBStop2k.addDestination(nodeAEk);
        nodeBStop2k.addDestination(nodeANk);

        nodeBStop3k.addDestination(nodeAAk);
        nodeBStop3k.addDestination(nodeAQk);

        nodeBStop4k.addDestination(nodeTk);
        nodeBStop4k.addDestination(nodeARk);

        nodeBStop5k.addDestination(nodeAWk);
        nodeBStop5k.addDestination(nodeBJk);

        nodeBStop6k.addDestination(nodeCCk);
        nodeBStop6k.addDestination(nodeCFk);

        nodeBStop7k.addDestination(nodeCQk);
        nodeBStop7k.addDestination(nodeCTk);

        nodeList.add(nodeAk);
        nodeList.add(nodeBk);
        nodeList.add(nodeCk);
        nodeList.add(nodeDk);
        nodeList.add(nodeEk);
        nodeList.add(nodeFk);
        nodeList.add(nodeGk);
        nodeList.add(nodeHk);
        nodeList.add(nodeIk);
        nodeList.add(nodeJk);
        nodeList.add(nodeKk);
        nodeList.add(nodeLk);
        nodeList.add(nodeMk);
        nodeList.add(nodeNk);
        nodeList.add(nodeOk);
        nodeList.add(nodePk);
        nodeList.add(nodeQk);
        nodeList.add(nodeRk);
        nodeList.add(nodeSk);
        nodeList.add(nodeTk);
        nodeList.add(nodeUk);
        nodeList.add(nodeVk);
        nodeList.add(nodeWk);
        nodeList.add(nodeXk);
        nodeList.add(nodeYk);
        nodeList.add(nodeZk);
        nodeList.add(nodeAAk);
        nodeList.add(nodeABk);
        nodeList.add(nodeACk);
        nodeList.add(nodeADk);
        nodeList.add(nodeAEk);
        nodeList.add(nodeAFk);
        nodeList.add(nodeAGk);
        nodeList.add(nodeAHk);
        nodeList.add(nodeAIk);
        nodeList.add(nodeAJk);
        nodeList.add(nodeAKk);
        nodeList.add(nodeALk);
        nodeList.add(nodeAMk);
        nodeList.add(nodeANk);
        nodeList.add(nodeAOk);
        nodeList.add(nodeAPk);
        nodeList.add(nodeAQk);
        nodeList.add(nodeARk);
        nodeList.add(nodeASk);
        nodeList.add(nodeATk);
        nodeList.add(nodeAUk);
        nodeList.add(nodeAVk);
        nodeList.add(nodeAWk);
        nodeList.add(nodeAXk);
        nodeList.add(nodeAYk);
        nodeList.add(nodeAZk);
        nodeList.add(nodeBAk);
        nodeList.add(nodeBBk);
        nodeList.add(nodeBCk);
        nodeList.add(nodeBDk);
        nodeList.add(nodeBEk);
        nodeList.add(nodeBFk);
        nodeList.add(nodeBGk);
        nodeList.add(nodeBHk);
        nodeList.add(nodeBIk);
        nodeList.add(nodeBJk);
        nodeList.add(nodeBKk);
        nodeList.add(nodeBLk);
        nodeList.add(nodeBMk);
        nodeList.add(nodeBNk);
        nodeList.add(nodeBOk);
        nodeList.add(nodeBPk);
        nodeList.add(nodeBQk);
        nodeList.add(nodeBRk);
        nodeList.add(nodeBSk);
        nodeList.add(nodeBTk);
        nodeList.add(nodeBUk);
        nodeList.add(nodeBVk);
        nodeList.add(nodeBWk);
        nodeList.add(nodeBXk);
        nodeList.add(nodeBYk);
        nodeList.add(nodeBZk);
        nodeList.add(nodeCAk);
        nodeList.add(nodeCBk);
        nodeList.add(nodeCCk);
        nodeList.add(nodeCDk);
        nodeList.add(nodeCEk);
        nodeList.add(nodeCFk);
        nodeList.add(nodeCGk);
        nodeList.add(nodeCHk);
        nodeList.add(nodeCIk);
        nodeList.add(nodeCJk);
        nodeList.add(nodeCKk);
        nodeList.add(nodeCLk);
        nodeList.add(nodeCMk);
        nodeList.add(nodeCNk);
        nodeList.add(nodeCOk);
        nodeList.add(nodeCPk);
        nodeList.add(nodeCQk);
        nodeList.add(nodeCRk);
        nodeList.add(nodeCSk);
        nodeList.add(nodeCTk);
        nodeList.add(nodeCUk);
        nodeList.add(nodeCVk);
        nodeList.add(nodeCXk);
        nodeList.add(nodeCYk);
        nodeList.add(nodeCZk);
        nodeList.add(nodeDAk);
        nodeList.add(nodeDBk);
        nodeList.add(nodeDCk);
        nodeList.add(nodeDDk);
        nodeList.add(nodeDFk);
        nodeList.add(nodeStop1k);
        nodeList.add(nodeStop2k);
        nodeList.add(nodeStop3k);
        nodeList.add(nodeStop4k);
        nodeList.add(nodeStop5k);
        nodeList.add(nodeStop6k);
        nodeList.add(nodeStop7k);
        nodeList.add(nodeStop8k);
        nodeList.add(nodeStop9k);
        nodeList.add(nodeStop10k);
        nodeList.add(nodeStop11k);
        nodeList.add(nodeStop12k);
        nodeList.add(nodeStop13k);
        nodeList.add(nodeBStop1k);
        nodeList.add(nodeBStop2k);
        nodeList.add(nodeBStop3k);
        nodeList.add(nodeBStop4k);
        nodeList.add(nodeBStop5k);
        nodeList.add(nodeBStop6k);
        nodeList.add(nodeBStop7k);


        graph.addNode(nodeAk);
        graph.addNode(nodeBk);
        graph.addNode(nodeCk);
        graph.addNode(nodeDk);
        graph.addNode(nodeEk);
        graph.addNode(nodeFk);
        graph.addNode(nodeGk);
        graph.addNode(nodeHk);
        graph.addNode(nodeIk);
        graph.addNode(nodeJk);
        graph.addNode(nodeKk);
        graph.addNode(nodeLk);
        graph.addNode(nodeMk);
        graph.addNode(nodeNk);
        graph.addNode(nodeOk);
        graph.addNode(nodePk);
        graph.addNode(nodeQk);
        graph.addNode(nodeRk);
        graph.addNode(nodeSk);
        graph.addNode(nodeTk);
        graph.addNode(nodeUk);
        graph.addNode(nodeVk);
        graph.addNode(nodeWk);
        graph.addNode(nodeXk);
        graph.addNode(nodeYk);
        graph.addNode(nodeZk);
        graph.addNode(nodeAAk);
        graph.addNode(nodeABk);
        graph.addNode(nodeACk);
        graph.addNode(nodeADk);
        graph.addNode(nodeAEk);
        graph.addNode(nodeAFk);
        graph.addNode(nodeAGk);
        graph.addNode(nodeAHk);
        graph.addNode(nodeAIk);
        graph.addNode(nodeAJk);
        graph.addNode(nodeAKk);
        graph.addNode(nodeALk);
        graph.addNode(nodeAMk);
        graph.addNode(nodeANk);
        graph.addNode(nodeAOk);
        graph.addNode(nodeAPk);
        graph.addNode(nodeAQk);
        graph.addNode(nodeARk);
        graph.addNode(nodeASk);
        graph.addNode(nodeATk);
        graph.addNode(nodeAUk);
        graph.addNode(nodeAVk);
        graph.addNode(nodeAWk);
        graph.addNode(nodeAXk);
        graph.addNode(nodeAYk);
        graph.addNode(nodeAZk);
        graph.addNode(nodeBAk);
        graph.addNode(nodeBBk);
        graph.addNode(nodeBCk);
        graph.addNode(nodeBDk);
        graph.addNode(nodeBEk);
        graph.addNode(nodeBFk);
        graph.addNode(nodeBGk);
        graph.addNode(nodeBHk);
        graph.addNode(nodeBIk);
        graph.addNode(nodeBJk);
        graph.addNode(nodeBKk);
        graph.addNode(nodeBLk);
        graph.addNode(nodeBMk);
        graph.addNode(nodeBNk);
        graph.addNode(nodeBOk);
        graph.addNode(nodeBPk);
        graph.addNode(nodeBQk);
        graph.addNode(nodeBRk);
        graph.addNode(nodeBSk);
        graph.addNode(nodeBTk);
        graph.addNode(nodeBUk);
        graph.addNode(nodeBVk);
        graph.addNode(nodeBWk);
        graph.addNode(nodeBXk);
        graph.addNode(nodeBYk);
        graph.addNode(nodeBZk);
        graph.addNode(nodeCAk);
        graph.addNode(nodeCBk);
        graph.addNode(nodeCCk);
        graph.addNode(nodeCDk);
        graph.addNode(nodeCEk);
        graph.addNode(nodeCFk);
        graph.addNode(nodeCGk);
        graph.addNode(nodeCHk);
        graph.addNode(nodeCIk);
        graph.addNode(nodeCJk);
        graph.addNode(nodeCKk);
        graph.addNode(nodeCLk);
        graph.addNode(nodeCMk);
        graph.addNode(nodeCNk);
        graph.addNode(nodeCOk);
        graph.addNode(nodeCPk);
        graph.addNode(nodeCQk);
        graph.addNode(nodeCRk);
        graph.addNode(nodeCSk);
        graph.addNode(nodeCTk);
        graph.addNode(nodeCUk);
        graph.addNode(nodeCVk);
        graph.addNode(nodeCXk);
        graph.addNode(nodeCYk);
        graph.addNode(nodeCZk);
        graph.addNode(nodeDAk);
        graph.addNode(nodeDBk);
        graph.addNode(nodeDCk);
        graph.addNode(nodeDDk);
        graph.addNode(nodeDFk);
        graph.addNode(nodeStop1k);
        graph.addNode(nodeStop2k);
        graph.addNode(nodeStop3k);
        graph.addNode(nodeStop4k);
        graph.addNode(nodeStop5k);
        graph.addNode(nodeStop6k);
        graph.addNode(nodeStop7k);
        graph.addNode(nodeStop8k);
        graph.addNode(nodeStop9k);
        graph.addNode(nodeStop10k);
        graph.addNode(nodeStop11k);
        graph.addNode(nodeStop12k);
        graph.addNode(nodeStop13k);
        graph.addNode(nodeBStop1k);
        graph.addNode(nodeBStop2k);
        graph.addNode(nodeBStop3k);
        graph.addNode(nodeBStop4k);
        graph.addNode(nodeBStop5k);
        graph.addNode(nodeBStop6k);
        graph.addNode(nodeBStop7k);

        nodeBStop1.addDestination(nodeBStop1k);
        nodeBStop1k.addDestination(nodeBStop1);

        nodeBStop2.addDestination(nodeBStop2k);
        nodeBStop2k.addDestination(nodeBStop2);

        nodeBStop3.addDestination(nodeBStop3k);
        nodeBStop3k.addDestination(nodeBStop3);

        nodeBStop4.addDestination(nodeBStop4k);
        nodeBStop4k.addDestination(nodeBStop4);

        nodeBStop5.addDestination(nodeBStop5k);
        nodeBStop5k.addDestination(nodeBStop5);

        nodeBStop6.addDestination(nodeBStop6k);
        nodeBStop6k.addDestination(nodeBStop6);

        nodeBStop7.addDestination(nodeBStop7k);
        nodeBStop7k.addDestination(nodeBStop7);

        //Add Car Routes
        Node nodeAc = new Node("Ac", nodeA.getX(), nodeA.getY(), Car.transportType);
        Node nodeBc = new Node("Bc", nodeB.getX(), nodeB.getY(), Car.transportType);
        Node nodeCc = new Node("Cc", nodeC.getX(), nodeC.getY(), Car.transportType);
        Node nodeDc = new Node("Dc", nodeD.getX(), nodeD.getY(), Car.transportType);
        Node nodeEc = new Node("Ec", nodeE.getX(), nodeE.getY(), Car.transportType);
        Node nodeFc = new Node("Fc", nodeF.getX(), nodeF.getY(), Car.transportType);
        Node nodeGc = new Node("Gc", nodeG.getX(), nodeG.getY(), Car.transportType);
        Node nodeHc = new Node("Hc", nodeH.getX(), nodeH.getY(), Car.transportType);
        Node nodeIc = new Node("Ic", nodeI.getX(), nodeI.getY(), Car.transportType);
        Node nodeJc = new Node("Jc", nodeJ.getX(), nodeJ.getY(), Car.transportType);
        Node nodeMc = new Node("Mc", nodeM.getX(), nodeM.getY(), Car.transportType);
        Node nodeNc = new Node("Nc", nodeN.getX(), nodeN.getY(), Car.transportType);
        Node nodeOc = new Node("Oc", nodeO.getX(), nodeO.getY(), Car.transportType);
        Node nodePc = new Node("Pc", nodeP.getX(), nodeP.getY(), Car.transportType);
        Node nodeQc = new Node("Qc", nodeQ.getX(), nodeQ.getY(), Car.transportType);
        Node nodeRc = new Node("Rc", nodeR.getX(), nodeR.getY(), Car.transportType);
        Node nodeSc = new Node("Sc", nodeS.getX(), nodeS.getY(), Car.transportType);
        Node nodeTc = new Node("Tc", nodeT.getX(), nodeT.getY(), Car.transportType);
        Node nodeUc = new Node("Uc", nodeU.getX(), nodeU.getY(), Car.transportType);
        Node nodeVc = new Node("Vc", nodeV.getX(), nodeV.getY(), Car.transportType);
        Node nodeWc = new Node("Wc", nodeW.getX(), nodeW.getY(), Car.transportType);
        Node nodeXc = new Node("Xc", nodeX.getX(), nodeX.getY(), Car.transportType);
        Node nodeYc = new Node("Yc", nodeY.getX(), nodeY.getY(), Car.transportType);
        Node nodeZc = new Node("Zc", nodeZ.getX(), nodeZ.getY(), Car.transportType);
        Node nodeAAc = new Node("AAc", nodeAA.getX(), nodeAA.getY(), Car.transportType);
        Node nodeABc = new Node("ABc", nodeAB.getX(), nodeAB.getY(), Car.transportType);
        Node nodeACc = new Node("ACc", nodeAC.getX(), nodeAC.getY(), Car.transportType);
        Node nodeADc = new Node("ADc", nodeAD.getX(), nodeAD.getY(), Car.transportType);
        Node nodeAFc = new Node("AFc", nodeAF.getX(), nodeAF.getY(), Car.transportType);
        Node nodeAGc = new Node("AGc", nodeAG.getX(), nodeAG.getY(), Car.transportType);
        Node nodeAIc = new Node("AIc", nodeAI.getX(), nodeAI.getY(), Car.transportType);
        Node nodeAJc = new Node("AJc", nodeAJ.getX(), nodeAJ.getY(), Car.transportType);
        Node nodeAKc = new Node("AKc", nodeAK.getX(), nodeAK.getY(), Car.transportType);
        Node nodeALc = new Node("ALc", nodeAL.getX(), nodeAL.getY(), Car.transportType);
        Node nodeAMc = new Node("AMc", nodeAM.getX(), nodeAM.getY(), Car.transportType);
        Node nodeANc = new Node("ANc", nodeAN.getX(), nodeAN.getY(), Car.transportType);
        Node nodeAOc = new Node("AOc", nodeAO.getX(), nodeAO.getY(), Car.transportType);
        Node nodeAPc = new Node("APc", nodeAP.getX(), nodeAP.getY(), Car.transportType);
        Node nodeAQc = new Node("AQc", nodeAQ.getX(), nodeAQ.getY(), Car.transportType);
        Node nodeARc = new Node("ARc", nodeAR.getX(), nodeAR.getY(), Car.transportType);
        Node nodeASc = new Node("ASc", nodeAS.getX(), nodeAS.getY(), Car.transportType);
        Node nodeATc = new Node("ATc", nodeAT.getX(), nodeAT.getY(), Car.transportType);
        Node nodeAUc = new Node("AUc", nodeAU.getX(), nodeAU.getY(), Car.transportType);
        Node nodeAVc = new Node("AVc", nodeAV.getX(), nodeAV.getY(), Car.transportType);
        Node nodeAWc = new Node("AWc", nodeAW.getX(), nodeAW.getY(), Car.transportType);
        Node nodeAXc = new Node("AXc", nodeAX.getX(), nodeAX.getY(), Car.transportType);
        Node nodeAYc = new Node("AYc", nodeAY.getX(), nodeAY.getY(), Car.transportType);
        Node nodeAZc = new Node("AZc", nodeAZ.getX(), nodeAZ.getY(), Car.transportType);
        Node nodeBAc = new Node("BAc", nodeBA.getX(), nodeBA.getY(), Car.transportType);
        Node nodeBBc = new Node("BBc", nodeBB.getX(), nodeBB.getY(), Car.transportType);
        Node nodeBCc = new Node("BCc", nodeBC.getX(), nodeBC.getY(), Car.transportType);
        Node nodeBDc = new Node("BDc", nodeBD.getX(), nodeBD.getY(), Car.transportType);
        Node nodeBEc = new Node("BEc", nodeBE.getX(), nodeBE.getY(), Car.transportType);
        Node nodeBFc = new Node("BFc", nodeBF.getX(), nodeBF.getY(), Car.transportType);
        Node nodeBGc = new Node("BGc", nodeBG.getX(), nodeBG.getY(), Car.transportType);
        Node nodeBHc = new Node("BHc", nodeBH.getX(), nodeBH.getY(), Car.transportType);
        Node nodeBIc = new Node("BIc", nodeBI.getX(), nodeBI.getY(), Car.transportType);
        Node nodeBJc = new Node("BJc", nodeBJ.getX(), nodeBJ.getY(), Car.transportType);
        Node nodeBKc = new Node("BKc", nodeBK.getX(), nodeBK.getY(), Car.transportType);
        Node nodeBLc = new Node("BLc", nodeBL.getX(), nodeBL.getY(), Car.transportType);
        Node nodeBMc = new Node("BMc", nodeBM.getX(), nodeBM.getY(), Car.transportType);
        Node nodeBNc = new Node("BNc", nodeBN.getX(), nodeBN.getY(), Car.transportType);
        Node nodeBOc = new Node("BOc", nodeBO.getX(), nodeBO.getY(), Car.transportType);
        Node nodeBPc = new Node("BPc", nodeBP.getX(), nodeBP.getY(), Car.transportType);
        Node nodeBQc = new Node("BQc", nodeBQ.getX(), nodeBQ.getY(), Car.transportType);
        Node nodeBRc = new Node("BRc", nodeBR.getX(), nodeBR.getY(), Car.transportType);
        Node nodeBSc = new Node("BSc", nodeBS.getX(), nodeBS.getY(), Car.transportType);
        Node nodeBTc = new Node("BTc", nodeBT.getX(), nodeBT.getY(), Car.transportType);
        Node nodeBUc = new Node("BUc", nodeBU.getX(), nodeBU.getY(), Car.transportType);
        Node nodeBVc = new Node("BVc", nodeBV.getX(), nodeBV.getY(), Car.transportType);
        Node nodeBWc = new Node("BWc", nodeBW.getX(), nodeBW.getY(), Car.transportType);
        Node nodeBXc = new Node("BXc", nodeBX.getX(), nodeBX.getY(), Car.transportType);
        Node nodeBYc = new Node("BYc", nodeBY.getX(), nodeBY.getY(), Car.transportType);
        Node nodeBZc = new Node("BZc", nodeBZ.getX(), nodeBZ.getY(), Car.transportType);
        Node nodeCAc = new Node("CAc", nodeCA.getX(), nodeCA.getY(), Car.transportType);
        Node nodeCBc = new Node("CBc", nodeCB.getX(), nodeCB.getY(), Car.transportType);
        Node nodeCCc = new Node("CCc", nodeCC.getX(), nodeCC.getY(), Car.transportType);
        Node nodeCDc = new Node("CDc", nodeCD.getX(), nodeCD.getY(), Car.transportType);
        Node nodeCEc = new Node("CEc", nodeCE.getX(), nodeCE.getY(), Car.transportType);
        Node nodeCFc = new Node("CFc", nodeCF.getX(), nodeCF.getY(), Car.transportType);
        Node nodeCGc = new Node("CGc", nodeCG.getX(), nodeCG.getY(), Car.transportType);
        Node nodeCHc = new Node("CHc", nodeCH.getX(), nodeCH.getY(), Car.transportType);
        Node nodeCIc = new Node("CIc", nodeCI.getX(), nodeCI.getY(), Car.transportType);
        Node nodeCJc = new Node("CJc", nodeCJ.getX(), nodeCJ.getY(), Car.transportType);
        Node nodeCKc = new Node("CKc", nodeCK.getX(), nodeCK.getY(), Car.transportType);
        Node nodeCLc = new Node("CLc", nodeCL.getX(), nodeCL.getY(), Car.transportType);
        Node nodeCMc = new Node("CMc", nodeCM.getX(), nodeCM.getY(), Car.transportType);
        Node nodeCNc = new Node("CNc", nodeCN.getX(), nodeCN.getY(), Car.transportType);
        Node nodeCOc = new Node("COc", nodeCO.getX(), nodeCO.getY(), Car.transportType);
        Node nodeCPc = new Node("CPc", nodeCP.getX(), nodeCP.getY(), Car.transportType);
        Node nodeCQc = new Node("CQc", nodeCQ.getX(), nodeCQ.getY(), Car.transportType);
        Node nodeCRc = new Node("CRc", nodeCR.getX(), nodeCR.getY(), Car.transportType);
        Node nodeCSc = new Node("CSc", nodeCS.getX(), nodeCS.getY(), Car.transportType);
        Node nodeCTc = new Node("CTc", nodeCT.getX(), nodeCT.getY(), Car.transportType);
        Node nodeCUc = new Node("CUc", nodeCU.getX(), nodeCU.getY(), Car.transportType);
        Node nodeCVc = new Node("CVc", nodeCV.getX(), nodeCV.getY(), Car.transportType);
        Node nodeCXc = new Node("CXc", nodeCX.getX(), nodeCX.getY(), Car.transportType);
        Node nodeCYc = new Node("CYc", nodeCY.getX(), nodeCY.getY(), Car.transportType);
        Node nodeCZc = new Node("CZc", nodeCZ.getX(), nodeCZ.getY(), Car.transportType);
        Node nodeDAc = new Node("DAc", nodeDA.getX(), nodeDA.getY(), Car.transportType);
        Node nodeDBc = new Node("DBc", nodeDB.getX(), nodeDB.getY(), Car.transportType);
        Node nodeDCc = new Node("DCc", nodeDC.getX(), nodeDC.getY(), Car.transportType);
        Node nodeDDc = new Node("DDc", nodeDD.getX(), nodeDD.getY(), Car.transportType);
        Node nodeDFc = new Node("DFc", nodeDF.getX(), nodeDF.getY(), Car.transportType);
        Node nodeStop1c = new Node("Stop1c", nodeStop1.getX(), nodeStop1.getY(), Car.transportType);
        Node nodeStop2c = new Node("Stop2c", nodeStop2.getX(), nodeStop2.getY(), Car.transportType);
        Node nodeStop3c = new Node("Stop3c", nodeStop3.getX(), nodeStop3.getY(), Car.transportType);
        Node nodeStop4c = new Node("Stop4c", nodeStop4.getX(), nodeStop4.getY(), Car.transportType);
        Node nodeStop5c = new Node("Stop5c", nodeStop5.getX(), nodeStop5.getY(), Car.transportType);
        Node nodeStop6c = new Node("Stop6c", nodeStop6.getX(), nodeStop6.getY(), Car.transportType);
        Node nodeStop7c = new Node("Stop7c", nodeStop7.getX(), nodeStop7.getY(), Car.transportType);
        Node nodeStop8c = new Node("Stop8c", nodeStop8.getX(), nodeStop8.getY(), Car.transportType);
        Node nodeStop9c = new Node("Stop9c", nodeStop9.getX(), nodeStop9.getY(), Car.transportType);
        Node nodeStop10c = new Node("Stop10c", nodeStop10.getX(), nodeStop10.getY(), Car.transportType);
        Node nodeStop11c = new Node("Stop11c", nodeStop11.getX(), nodeStop11.getY(), Car.transportType);
        Node nodeStop12c = new Node("Stop12c", nodeStop12.getX(), nodeStop12.getY(), Car.transportType);
        Node nodeStop13c = new Node("Stop13c", nodeStop13.getX(), nodeStop13.getY(), Car.transportType);
        Node nodeBStop1c = new Node("BStop1c", nodeBStop1.getX(), nodeBStop1.getY(), Car.transportType);
        Node nodeBStop2c = new Node("BStop2c", nodeBStop2.getX(), nodeBStop2.getY(), Car.transportType);
        Node nodeBStop3c = new Node("BStop3c", nodeBStop3.getX(), nodeBStop3.getY(), Car.transportType);
        Node nodeBStop4c = new Node("BStop4c", nodeBStop4.getX(), nodeBStop4.getY(), Car.transportType);
        Node nodeBStop5c = new Node("BStop5c", nodeBStop5.getX(), nodeBStop5.getY(), Car.transportType);
        Node nodeBStop6c = new Node("BStop6c", nodeBStop6.getX(), nodeBStop6.getY(), Car.transportType);
        Node nodeBStop7c = new Node("BStop7c", nodeBStop7.getX(), nodeBStop7.getY(), Car.transportType);
        Node carStart1 = new Node("CS1c", J4Start.getX(),J4Start.getY(),Car.transportType);


        nodeAc.addDestination(nodeBc);

        nodeBc.addDestination(nodeAc);
        nodeBc.addDestination(nodeCc);

        nodeCc.addDestination(nodeBc);
        nodeCc.addDestination(nodeDc);

        nodeDc.addDestination(nodeCc);
        nodeDc.addDestination(nodeEc);
        nodeDc.addDestination(nodeStop1c);

        nodeEc.addDestination(nodeDc);
        nodeEc.addDestination(nodeHc);
        nodeEc.addDestination(nodeBStop1c);

        nodeFc.addDestination(nodeStop1c);
        nodeFc.addDestination(nodeGc);
        nodeFc.addDestination(nodeNc);

        nodeGc.addDestination(nodeFc);
        nodeGc.addDestination(nodeIc);
        nodeGc.addDestination(nodeMc);

        nodeHc.addDestination(nodeEc);
        nodeHc.addDestination(nodeIc);
        nodeHc.addDestination(nodeJc);

        nodeIc.addDestination(nodeGc);
        nodeIc.addDestination(nodeHc);

        nodeJc.addDestination(nodeHc);
        nodeJc.addDestination(nodeADc);
        nodeJc.addDestination(nodeAFc);

        nodeMc.addDestination(nodeGc);
        nodeMc.addDestination(nodeABc);

        nodeNc.addDestination(nodeFc);
        nodeNc.addDestination(nodeOc);
        nodeNc.addDestination(nodePc);

        nodeOc.addDestination(nodeNc);

        nodePc.addDestination(nodeNc);
        nodePc.addDestination(nodeQc);
        nodePc.addDestination(nodeStop2c);

        nodeQc.addDestination(nodePc);

        nodeRc.addDestination(nodeXc);
        nodeRc.addDestination(nodeYc);
        nodeRc.addDestination(nodeABc);

        nodeSc.addDestination(nodeStop2c);
        nodeSc.addDestination(nodeTc);
        nodeSc.addDestination(nodeVc);

        nodeTc.addDestination(nodeSc);
        nodeTc.addDestination(nodeUc);
        nodeTc.addDestination(nodeBStop4c);

        nodeUc.addDestination(nodeTc);
        nodeUc.addDestination(nodeZc);

        nodeVc.addDestination(nodeSc);

        nodeWc.addDestination(nodeYc);

        nodeXc.addDestination(nodeRc);

        nodeYc.addDestination(nodeRc);
        nodeYc.addDestination(nodeWc);
        nodeYc.addDestination(nodeZc);

        nodeZc.addDestination(nodeUc);
        nodeZc.addDestination(nodeYc);
        nodeZc.addDestination(nodeAQc);
        nodeZc.addDestination(nodeStop3c);

        nodeAAc.addDestination(nodeABc);
        nodeAAc.addDestination(nodeACc);
        nodeAAc.addDestination(nodeBStop3c);

        nodeABc.addDestination(nodeMc);
        nodeABc.addDestination(nodeRc);
        nodeABc.addDestination(nodeAAc);

        nodeACc.addDestination(nodeAAc);
        nodeACc.addDestination(nodeADc);

        nodeADc.addDestination(nodeJc);
        nodeADc.addDestination(nodeACc);

        nodeAFc.addDestination(nodeJc);
        nodeAFc.addDestination(nodeAGc);
        nodeAFc.addDestination(nodeAKc);
        nodeAFc.addDestination(nodeDDc);

        nodeAGc.addDestination(nodeBStop1c);
        nodeAGc.addDestination(nodeAFc);
        nodeAGc.addDestination(nodeAJc);


        nodeAIc.addDestination(nodeAJc);

        nodeAJc.addDestination(nodeDDc);
        nodeAJc.addDestination(nodeAJc);
        nodeAJc.addDestination(nodeStop7c);

        nodeAKc.addDestination(nodeAFc);
        nodeAKc.addDestination(nodeStop6c);
        nodeAKc.addDestination(nodeCMc);

        nodeALc.addDestination(nodeStop6c);
        nodeALc.addDestination(nodeAMc);
        nodeALc.addDestination(nodeCLc);

        nodeAMc.addDestination(nodeALc);
        nodeAMc.addDestination(nodeANc);
        nodeAMc.addDestination(nodeCKc);

        nodeANc.addDestination(nodeAMc);
        nodeANc.addDestination(nodeStop5c);

        nodeAOc.addDestination(nodeStop5c);
        nodeAOc.addDestination(nodeAPc);
        nodeAOc.addDestination(nodeBEc);

        nodeAPc.addDestination(nodeAOc);
        nodeAPc.addDestination(nodeAQc);
        nodeAPc.addDestination(nodeBDc);

        nodeAQc.addDestination(nodeZc);
        nodeAQc.addDestination(nodeBStop3c);
        nodeAQc.addDestination(nodeAPc);

        nodeAQc.addDestination(nodeZc);
        nodeAQc.addDestination(nodeAAc);
        nodeAQc.addDestination(nodeAPc);

        nodeARc.addDestination(nodeBStop4c);
        nodeARc.addDestination(nodeASc);
        nodeARc.addDestination(nodeDFc);

        nodeASc.addDestination(nodeARc);
        nodeASc.addDestination(nodeATc);
        nodeASc.addDestination(nodeAVc);

        nodeATc.addDestination(nodeASc);
        nodeATc.addDestination(nodeAUc);

        nodeAUc.addDestination(nodeATc);

        nodeAVc.addDestination(nodeASc);

        nodeAWc.addDestination(nodeAXc);
        nodeAWc.addDestination(nodeBStop5c);
        nodeAWc.addDestination(nodeDFc);

        nodeAXc.addDestination(nodeAWc);
        nodeAXc.addDestination(nodeStop4c);
        nodeAXc.addDestination(nodeBGc);

        nodeAYc.addDestination(nodeStop4c);
        nodeAYc.addDestination(nodeAZc);
        nodeAYc.addDestination(nodeBDc);

        nodeAZc.addDestination(nodeAYc);
        nodeAZc.addDestination(nodeBAc);
        nodeAZc.addDestination(nodeBCc);

        nodeBAc.addDestination(nodeAZc);
        nodeBAc.addDestination(nodeBBc);

        nodeBBc.addDestination(nodeBAc);

        nodeBCc.addDestination(nodeAZc);

        nodeBDc.addDestination(nodeAPc);
        nodeBDc.addDestination(nodeAYc);
        nodeBDc.addDestination(nodeBEc);

        nodeBEc.addDestination(nodeAOc);
        nodeBEc.addDestination(nodeBDc);
        nodeBEc.addDestination(nodeBFc);
        nodeBEc.addDestination(nodeBUc);

        nodeBFc.addDestination(nodeBEc);
        nodeBFc.addDestination(nodeBGc);
        nodeBFc.addDestination(nodeBQc);

        nodeBGc.addDestination(nodeAXc);
        nodeBGc.addDestination(nodeBFc);

        nodeBHc.addDestination(nodeStop8c);
        nodeBHc.addDestination(nodeBPc);

        nodeBIc.addDestination(nodeStop8c);
        nodeBIc.addDestination(nodeBJc);

        nodeBJc.addDestination(nodeBStop5c);
        nodeBJc.addDestination(nodeBIc);
        nodeBJc.addDestination(nodeBKc);

        nodeBKc.addDestination(nodeBJc);
        nodeBKc.addDestination(nodeBLc);
        nodeBKc.addDestination(nodeBMc);

        nodeBLc.addDestination(nodeBKc);

        nodeBMc.addDestination(nodeBKc);
        nodeBMc.addDestination(nodeBNc);
        nodeBMc.addDestination(nodeBOc);

        nodeBNc.addDestination(nodeBMc);

        nodeBOc.addDestination(nodeBMc);

        nodeBPc.addDestination(nodeBHc);
        nodeBPc.addDestination(nodeStop9c);

        nodeBQc.addDestination(nodeBFc);
        nodeBQc.addDestination(nodeBRc);
        nodeBQc.addDestination(nodeBSc);

        nodeBRc.addDestination(nodeStop9c);
        nodeBRc.addDestination(nodeBQc);
        nodeBRc.addDestination(nodeCAc);

        nodeBSc.addDestination(nodeBQc);
        nodeBSc.addDestination(nodeBTc);
        nodeBSc.addDestination(nodeBUc);

        nodeBTc.addDestination(nodeBSc);

        nodeBUc.addDestination(nodeBEc);
        nodeBUc.addDestination(nodeBSc);
        nodeBUc.addDestination(nodeBVc);

        nodeBVc.addDestination(nodeBUc);

        nodeBWc.addDestination(nodeBXc);
        nodeBWc.addDestination(nodeBYc);

        nodeBXc.addDestination(nodeBWc);
        nodeBXc.addDestination(nodeBZc);
        nodeBXc.addDestination(nodeCAc);

        nodeBYc.addDestination(nodeBWc);
        nodeBYc.addDestination(nodeBZc);

        nodeBZc.addDestination(nodeBXc);
        nodeBZc.addDestination(nodeBZc);
        nodeBZc.addDestination(nodeCJc);

        nodeCAc.addDestination(nodeBRc);
        nodeCAc.addDestination(nodeBXc);
        nodeCAc.addDestination(nodeCBc);
        nodeCAc.addDestination(nodeCFc);

        nodeCBc.addDestination(nodeCAc);
        nodeCBc.addDestination(nodeCCc);

        nodeCCc.addDestination(nodeCBc);
        nodeCCc.addDestination(nodeCDc);
        nodeCCc.addDestination(nodeCEc);
        nodeCCc.addDestination(nodeBStop6c);

        nodeCDc.addDestination(nodeCCc);

        nodeCEc.addDestination(nodeCCc);

        nodeCFc.addDestination(nodeCAc);
        nodeCFc.addDestination(nodeBStop6c);
        nodeCFc.addDestination(nodeCGc);

        nodeCGc.addDestination(nodeCFc);
        nodeCGc.addDestination(nodeCHc);
        nodeCGc.addDestination(nodeCIc);
        nodeCGc.addDestination(nodeCSc);

        nodeCHc.addDestination(nodeCGc);
        nodeCHc.addDestination(nodeCTc);
        nodeCHc.addDestination(nodeCVc);
        nodeCHc.addDestination(nodeCXc);

        nodeCIc.addDestination(nodeCGc);
        nodeCIc.addDestination(nodeStop10c);
        nodeCIc.addDestination(nodeCLc);
        nodeCIc.addDestination(nodeCNc);

        nodeCJc.addDestination(nodeBZc);
        nodeCJc.addDestination(nodeStop10c);
        nodeCJc.addDestination(nodeCKc);

        nodeCKc.addDestination(nodeAMc);
        nodeCKc.addDestination(nodeCJc);
        nodeCKc.addDestination(nodeCLc);

        nodeCLc.addDestination(nodeALc);
        nodeCLc.addDestination(nodeCIc);
        nodeCLc.addDestination(nodeCKc);

        nodeCMc.addDestination(nodeAKc);
        nodeCMc.addDestination(nodeCNc);
        nodeCMc.addDestination(nodeDDc);

        nodeCNc.addDestination(nodeCIc);
        nodeCNc.addDestination(nodeCMc);
        nodeCNc.addDestination(nodeCOc);
        nodeCNc.addDestination(nodeCRc);

        nodeCOc.addDestination(nodeCNc);
        nodeCOc.addDestination(nodeCPc);
        nodeCOc.addDestination(nodeDDc);

        nodeCPc.addDestination(nodeCOc);
        nodeCPc.addDestination(nodeCQc);
        nodeCPc.addDestination(nodeCRc);

        nodeCQc.addDestination(nodeCPc);
        nodeCQc.addDestination(nodeBStop7c);

        nodeCRc.addDestination(nodeCNc);
        nodeCRc.addDestination(nodeCPc);
        nodeCRc.addDestination(nodeCSc);

        nodeCSc.addDestination(nodeCGc);
        nodeCSc.addDestination(nodeCRc);
        nodeCSc.addDestination(nodeStop11c);

        nodeCTc.addDestination(nodeCHc);
        nodeCTc.addDestination(nodeBStop7c);
        nodeCTc.addDestination(nodeStop11c);
        nodeCTc.addDestination(nodeCUc);

        nodeCUc.addDestination(nodeCTc);
        nodeCUc.addDestination(nodeCVc);

        nodeCVc.addDestination(nodeCHc);
        nodeCVc.addDestination(nodeCUc);

        nodeCXc.addDestination(nodeCHc);
        nodeCXc.addDestination(nodeCYc);
        nodeCXc.addDestination(nodeStop12c);

        nodeCYc.addDestination(nodeCXc);

        nodeCZc.addDestination(nodeStop12c);
        nodeCZc.addDestination(nodeDAc);
        nodeCZc.addDestination(nodeDBc);

        nodeDAc.addDestination(nodeCZc);

        nodeDBc.addDestination(nodeCZc);
        nodeDBc.addDestination(nodeStop13c);

        nodeDCc.addDestination(nodeStop13c);

        nodeDDc.addDestination(nodeAFc);
        nodeDDc.addDestination(nodeAJc);
        nodeDDc.addDestination(nodeCMc);
        nodeDDc.addDestination(nodeCOc);

        nodeDFc.addDestination(nodeStop3c);
        nodeDFc.addDestination(nodeARc);
        nodeDFc.addDestination(nodeAWc);

        nodeStop1c.addDestination(nodeDc);
        nodeStop1c.addDestination(nodeFc);

        nodeStop2c.addDestination(nodePc);
        nodeStop2c.addDestination(nodeSc);

        nodeStop3c.addDestination(nodeZc);
        nodeStop3c.addDestination(nodeDFc);

        nodeStop4c.addDestination(nodeAXc);
        nodeStop4c.addDestination(nodeAYc);

        nodeStop5c.addDestination(nodeANc);
        nodeStop5c.addDestination(nodeAOc);

        nodeStop6c.addDestination(nodeAKc);
        nodeStop6c.addDestination(nodeALc);

        nodeStop7c.addDestination(nodeAJc);

        nodeStop8c.addDestination(nodeBIc);
        nodeStop8c.addDestination(nodeBHc);

        nodeStop9c.addDestination(nodeBPc);
        nodeStop9c.addDestination(nodeBRc);

        nodeStop10c.addDestination(nodeCJc);
        nodeStop10c.addDestination(nodeCIc);

        nodeStop11c.addDestination(nodeCSc);
        nodeStop11c.addDestination(nodeCTc);

        nodeStop12c.addDestination(nodeCXc);
        nodeStop12c.addDestination(nodeCZc);

        nodeStop13c.addDestination(nodeDBc);
        nodeStop13c.addDestination(nodeDCc);

        nodeBStop1c.addDestination(nodeEc);
        nodeBStop1c.addDestination(nodeAGc);

        nodeBStop3c.addDestination(nodeAAc);
        nodeBStop3c.addDestination(nodeAQc);

        nodeBStop4c.addDestination(nodeTc);
        nodeBStop4c.addDestination(nodeARc);

        nodeBStop5c.addDestination(nodeAWc);
        nodeBStop5c.addDestination(nodeBJc);

        nodeBStop6c.addDestination(nodeCCc);
        nodeBStop6c.addDestination(nodeCFc);

        nodeBStop7c.addDestination(nodeCQc);
        nodeBStop7c.addDestination(nodeCTc);

        nodeA.addDestination(nodeAc);
        nodeAc.addDestination(nodeA);

        nodeB.addDestination(nodeBc);
        nodeBc.addDestination(nodeB);

        nodeC.addDestination(nodeCc);
        nodeCc.addDestination(nodeC);

        nodeD.addDestination(nodeDc);
        nodeDc.addDestination(nodeD);

        nodeE.addDestination(nodeEc);
        nodeEc.addDestination(nodeE);

        nodeF.addDestination(nodeFc);
        nodeFc.addDestination(nodeF);

        nodeG.addDestination(nodeGc);
        nodeGc.addDestination(nodeG);

        nodeH.addDestination(nodeHc);
        nodeHc.addDestination(nodeH);

        nodeI.addDestination(nodeIc);
        nodeIc.addDestination(nodeI);

        nodeJ.addDestination(nodeJc);
        nodeJc.addDestination(nodeJ);

        nodeM.addDestination(nodeMc);
        nodeMc.addDestination(nodeM);

        nodeN.addDestination(nodeNc);
        nodeNc.addDestination(nodeN);

        nodeO.addDestination(nodeOc);
        nodeOc.addDestination(nodeO);

        nodeP.addDestination(nodePc);
        nodePc.addDestination(nodeP);

        nodeQ.addDestination(nodeQc);
        nodeQc.addDestination(nodeQ);

        nodeR.addDestination(nodeRc);
        nodeRc.addDestination(nodeR);

        nodeS.addDestination(nodeSc);
        nodeSc.addDestination(nodeS);

        nodeT.addDestination(nodeTc);
        nodeTc.addDestination(nodeT);

        nodeU.addDestination(nodeUc);
        nodeUc.addDestination(nodeU);

        nodeV.addDestination(nodeVc);
        nodeVc.addDestination(nodeV);

        nodeW.addDestination(nodeWc);
        nodeWc.addDestination(nodeW);

        nodeX.addDestination(nodeXc);
        nodeXc.addDestination(nodeX);

        nodeY.addDestination(nodeYc);
        nodeYc.addDestination(nodeY);

        nodeZ.addDestination(nodeZc);
        nodeZc.addDestination(nodeZ);

        nodeAA.addDestination(nodeAAc);
        nodeAAc.addDestination(nodeAA);

        nodeAB.addDestination(nodeABc);
        nodeABc.addDestination(nodeAB);

        nodeAC.addDestination(nodeACc);
        nodeACc.addDestination(nodeAC);

        nodeAD.addDestination(nodeADc);
        nodeADc.addDestination(nodeAD);

        nodeAF.addDestination(nodeAFc);
        nodeAFc.addDestination(nodeAF);

        nodeAG.addDestination(nodeAGc);
        nodeAGc.addDestination(nodeAG);

        nodeAI.addDestination(nodeAIc);
        nodeAIc.addDestination(nodeAI);

        nodeAJ.addDestination(nodeAJc);
        nodeAJc.addDestination(nodeAJ);

        nodeAK.addDestination(nodeAKc);
        nodeAKc.addDestination(nodeAK);

        nodeAL.addDestination(nodeALc);
        nodeALc.addDestination(nodeAL);

        nodeAM.addDestination(nodeAMc);
        nodeAMc.addDestination(nodeAM);

        nodeAN.addDestination(nodeANc);
        nodeANc.addDestination(nodeAN);

        nodeAO.addDestination(nodeAOc);
        nodeAOc.addDestination(nodeAO);

        nodeAP.addDestination(nodeAPc);
        nodeAPc.addDestination(nodeAP);

        nodeAQ.addDestination(nodeAQc);
        nodeAQc.addDestination(nodeAQ);

        nodeAR.addDestination(nodeARc);
        nodeARc.addDestination(nodeAR);

        nodeAS.addDestination(nodeASc);
        nodeASc.addDestination(nodeAS);

        nodeAT.addDestination(nodeATc);
        nodeATc.addDestination(nodeAT);

        nodeAU.addDestination(nodeAUc);
        nodeAUc.addDestination(nodeAU);

        nodeAV.addDestination(nodeAVc);
        nodeAVc.addDestination(nodeAV);

        nodeAW.addDestination(nodeAWc);
        nodeAWc.addDestination(nodeAW);

        nodeAX.addDestination(nodeAXc);
        nodeAXc.addDestination(nodeAX);

        nodeAY.addDestination(nodeAYc);
        nodeAYc.addDestination(nodeAY);

        nodeAZ.addDestination(nodeAZc);
        nodeAZc.addDestination(nodeAZ);

        nodeBA.addDestination(nodeBAc);
        nodeBAc.addDestination(nodeBA);

        nodeBB.addDestination(nodeBBc);
        nodeBBc.addDestination(nodeBB);

        nodeBC.addDestination(nodeBCc);
        nodeBCc.addDestination(nodeBC);

        nodeBD.addDestination(nodeBDc);
        nodeBDc.addDestination(nodeBD);

        nodeBE.addDestination(nodeBEc);
        nodeBEc.addDestination(nodeBE);

        nodeBF.addDestination(nodeBFc);
        nodeBFc.addDestination(nodeBF);

        nodeBG.addDestination(nodeBGc);
        nodeBGc.addDestination(nodeBG);

        nodeBH.addDestination(nodeBHc);
        nodeBHc.addDestination(nodeBH);

        nodeBI.addDestination(nodeBIc);
        nodeBIc.addDestination(nodeBI);

        nodeBJ.addDestination(nodeBJc);
        nodeBJc.addDestination(nodeBJ);

        nodeBK.addDestination(nodeBKc);
        nodeBKc.addDestination(nodeBK);

        nodeBL.addDestination(nodeBLc);
        nodeBLc.addDestination(nodeBL);

        nodeBM.addDestination(nodeBMc);
        nodeBMc.addDestination(nodeBM);

        nodeBN.addDestination(nodeBNc);
        nodeBNc.addDestination(nodeBN);

        nodeBO.addDestination(nodeBOc);
        nodeBOc.addDestination(nodeBO);

        nodeBP.addDestination(nodeBPc);
        nodeBPc.addDestination(nodeBP);

        nodeBQ.addDestination(nodeBQc);
        nodeBQc.addDestination(nodeBQ);

        nodeBR.addDestination(nodeBRc);
        nodeBRc.addDestination(nodeBR);

        nodeBS.addDestination(nodeBSc);
        nodeBSc.addDestination(nodeBS);

        nodeBT.addDestination(nodeBTc);
        nodeBTc.addDestination(nodeBT);

        nodeBU.addDestination(nodeBUc);
        nodeBUc.addDestination(nodeBU);

        nodeBV.addDestination(nodeBVc);
        nodeBVc.addDestination(nodeBV);

        nodeBW.addDestination(nodeBWc);
        nodeBWc.addDestination(nodeBW);

        nodeBX.addDestination(nodeBXc);
        nodeBXc.addDestination(nodeBX);

        nodeBY.addDestination(nodeBYc);
        nodeBYc.addDestination(nodeBY);

        nodeBZ.addDestination(nodeBZc);
        nodeBZc.addDestination(nodeBZ);

        nodeCA.addDestination(nodeCAc);
        nodeCAc.addDestination(nodeCA);

        nodeCB.addDestination(nodeCBc);
        nodeCBc.addDestination(nodeCB);

        nodeCC.addDestination(nodeCCc);
        nodeCCc.addDestination(nodeCC);

        nodeCD.addDestination(nodeCDc);
        nodeCDc.addDestination(nodeCD);

        nodeCE.addDestination(nodeCEc);
        nodeCEc.addDestination(nodeCE);

        nodeCF.addDestination(nodeCFc);
        nodeCFc.addDestination(nodeCF);

        nodeCG.addDestination(nodeCGc);
        nodeCGc.addDestination(nodeCG);

        nodeCH.addDestination(nodeCHc);
        nodeCHc.addDestination(nodeCH);

        nodeCI.addDestination(nodeCIc);
        nodeCIc.addDestination(nodeCI);

        nodeCJ.addDestination(nodeCJc);
        nodeCJc.addDestination(nodeCJ);

        nodeCK.addDestination(nodeCKc);
        nodeCKc.addDestination(nodeCK);

        nodeCL.addDestination(nodeCLc);
        nodeCLc.addDestination(nodeCL);

        nodeCM.addDestination(nodeCMc);
        nodeCMc.addDestination(nodeCM);

        nodeCN.addDestination(nodeCNc);
        nodeCNc.addDestination(nodeCN);

        nodeCO.addDestination(nodeCOc);
        nodeCOc.addDestination(nodeCO);

        nodeCP.addDestination(nodeCPc);
        nodeCPc.addDestination(nodeCP);

        nodeCQ.addDestination(nodeCQc);
        nodeCQc.addDestination(nodeCQ);

        nodeCR.addDestination(nodeCRc);
        nodeCRc.addDestination(nodeCR);

        nodeCS.addDestination(nodeCSc);
        nodeCSc.addDestination(nodeCS);

        nodeCT.addDestination(nodeCTc);
        nodeCTc.addDestination(nodeCT);

        nodeCU.addDestination(nodeCUc);
        nodeCUc.addDestination(nodeCU);

        nodeCV.addDestination(nodeCVc);
        nodeCVc.addDestination(nodeCV);

        nodeCX.addDestination(nodeCXc);
        nodeCXc.addDestination(nodeCX);

        nodeCY.addDestination(nodeCYc);
        nodeCYc.addDestination(nodeCY);

        nodeCZ.addDestination(nodeCZc);
        nodeCZc.addDestination(nodeCZ);

        nodeDA.addDestination(nodeDAc);
        nodeDAc.addDestination(nodeDA);

        nodeDB.addDestination(nodeDBc);
        nodeDBc.addDestination(nodeDB);

        nodeDC.addDestination(nodeDCc);
        nodeDCc.addDestination(nodeDC);

        nodeDD.addDestination(nodeDDc);
        nodeDDc.addDestination(nodeDD);

        nodeDF.addDestination(nodeDFc);
        nodeDFc.addDestination(nodeDF);

        nodeStop1.addDestination(nodeStop1c);
        nodeStop1c.addDestination(nodeStop1);

        nodeStop2.addDestination(nodeStop2c);
        nodeStop2c.addDestination(nodeStop2);

        nodeStop3.addDestination(nodeStop3c);
        nodeStop3c.addDestination(nodeStop3);

        nodeStop4.addDestination(nodeStop4c);
        nodeStop4c.addDestination(nodeStop4);

        nodeStop5.addDestination(nodeStop5c);
        nodeStop5c.addDestination(nodeStop5);

        nodeStop6.addDestination(nodeStop6c);
        nodeStop6c.addDestination(nodeStop6);

        nodeStop7.addDestination(nodeStop7c);
        nodeStop7c.addDestination(nodeStop7);

        nodeStop8.addDestination(nodeStop8c);
        nodeStop8c.addDestination(nodeStop8);

        nodeStop9.addDestination(nodeStop9c);
        nodeStop9c.addDestination(nodeStop9);

        nodeStop10.addDestination(nodeStop10c);
        nodeStop10c.addDestination(nodeStop10);

        nodeStop11.addDestination(nodeStop11c);
        nodeStop11c.addDestination(nodeStop11);

        nodeStop12.addDestination(nodeStop12c);
        nodeStop12c.addDestination(nodeStop12);

        nodeStop13.addDestination(nodeStop13c);
        nodeStop13c.addDestination(nodeStop13);

        nodeBStop1.addDestination(nodeBStop1c);
        nodeBStop1c.addDestination(nodeBStop1);

        nodeBStop2.addDestination(nodeBStop2c);
        nodeBStop2c.addDestination(nodeBStop2);

        nodeBStop3.addDestination(nodeBStop3c);
        nodeBStop3c.addDestination(nodeBStop3);

        nodeBStop4.addDestination(nodeBStop4c);
        nodeBStop4c.addDestination(nodeBStop4);

        nodeBStop5.addDestination(nodeBStop5c);
        nodeBStop5c.addDestination(nodeBStop5);

        nodeBStop6.addDestination(nodeBStop6c);
        nodeBStop6c.addDestination(nodeBStop6);

        nodeBStop7.addDestination(nodeBStop7c);
        nodeBStop7c.addDestination(nodeBStop7);

        nodeList.add(nodeAc);
        nodeList.add(nodeBc);
        nodeList.add(nodeCc);
        nodeList.add(nodeDc);
        nodeList.add(nodeEc);
        nodeList.add(nodeFc);
        nodeList.add(nodeGc);
        nodeList.add(nodeHc);
        nodeList.add(nodeIc);
        nodeList.add(nodeJc);
        nodeList.add(nodeMc);
        nodeList.add(nodeNc);
        nodeList.add(nodeOc);
        nodeList.add(nodePc);
        nodeList.add(nodeQc);
        nodeList.add(nodeRc);
        nodeList.add(nodeSc);
        nodeList.add(nodeTc);
        nodeList.add(nodeUc);
        nodeList.add(nodeVc);
        nodeList.add(nodeWc);
        nodeList.add(nodeXc);
        nodeList.add(nodeYc);
        nodeList.add(nodeZc);
        nodeList.add(nodeAAc);
        nodeList.add(nodeABc);
        nodeList.add(nodeACc);
        nodeList.add(nodeADc);
        nodeList.add(nodeAFc);
        nodeList.add(nodeAGc);
        nodeList.add(nodeAIc);
        nodeList.add(nodeAJc);
        nodeList.add(nodeAKc);
        nodeList.add(nodeALc);
        nodeList.add(nodeAMc);
        nodeList.add(nodeANc);
        nodeList.add(nodeAOc);
        nodeList.add(nodeAPc);
        nodeList.add(nodeAQc);
        nodeList.add(nodeARc);
        nodeList.add(nodeASc);
        nodeList.add(nodeATc);
        nodeList.add(nodeAUc);
        nodeList.add(nodeAVc);
        nodeList.add(nodeAWc);
        nodeList.add(nodeAXc);
        nodeList.add(nodeAYc);
        nodeList.add(nodeAZc);
        nodeList.add(nodeBAc);
        nodeList.add(nodeBBc);
        nodeList.add(nodeBCc);
        nodeList.add(nodeBDc);
        nodeList.add(nodeBEc);
        nodeList.add(nodeBFc);
        nodeList.add(nodeBGc);
        nodeList.add(nodeBHc);
        nodeList.add(nodeBIc);
        nodeList.add(nodeBJc);
        nodeList.add(nodeBKc);
        nodeList.add(nodeBLc);
        nodeList.add(nodeBMc);
        nodeList.add(nodeBNc);
        nodeList.add(nodeBOc);
        nodeList.add(nodeBPc);
        nodeList.add(nodeBQc);
        nodeList.add(nodeBRc);
        nodeList.add(nodeBSc);
        nodeList.add(nodeBTc);
        nodeList.add(nodeBUc);
        nodeList.add(nodeBVc);
        nodeList.add(nodeBWc);
        nodeList.add(nodeBXc);
        nodeList.add(nodeBYc);
        nodeList.add(nodeBZc);
        nodeList.add(nodeCAc);
        nodeList.add(nodeCBc);
        nodeList.add(nodeCCc);
        nodeList.add(nodeCDc);
        nodeList.add(nodeCEc);
        nodeList.add(nodeCFc);
        nodeList.add(nodeCGc);
        nodeList.add(nodeCHc);
        nodeList.add(nodeCIc);
        nodeList.add(nodeCJc);
        nodeList.add(nodeCKc);
        nodeList.add(nodeCLc);
        nodeList.add(nodeCMc);
        nodeList.add(nodeCNc);
        nodeList.add(nodeCOc);
        nodeList.add(nodeCPc);
        nodeList.add(nodeCQc);
        nodeList.add(nodeCRc);
        nodeList.add(nodeCSc);
        nodeList.add(nodeCTc);
        nodeList.add(nodeCUc);
        nodeList.add(nodeCVc);
        nodeList.add(nodeCXc);
        nodeList.add(nodeCYc);
        nodeList.add(nodeCZc);
        nodeList.add(nodeDAc);
        nodeList.add(nodeDBc);
        nodeList.add(nodeDCc);
        nodeList.add(nodeDDc);
        nodeList.add(nodeDFc);
        nodeList.add(nodeStop1c);
        nodeList.add(nodeStop2c);
        nodeList.add(nodeStop3c);
        nodeList.add(nodeStop4c);
        nodeList.add(nodeStop5c);
        nodeList.add(nodeStop6c);
        nodeList.add(nodeStop7c);
        nodeList.add(nodeStop8c);
        nodeList.add(nodeStop9c);
        nodeList.add(nodeStop10c);
        nodeList.add(nodeStop11c);
        nodeList.add(nodeStop12c);
        nodeList.add(nodeStop13c);
        nodeList.add(nodeBStop1c);
        nodeList.add(nodeBStop2c);
        nodeList.add(nodeBStop3c);
        nodeList.add(nodeBStop4c);
        nodeList.add(nodeBStop5c);
        nodeList.add(nodeBStop6c);
        nodeList.add(nodeBStop7c);

        graph.addNode(nodeAc);
        graph.addNode(nodeBc);
        graph.addNode(nodeCc);
        graph.addNode(nodeDc);
        graph.addNode(nodeEc);
        graph.addNode(nodeFc);
        graph.addNode(nodeGc);
        graph.addNode(nodeHc);
        graph.addNode(nodeIc);
        graph.addNode(nodeJc);
        graph.addNode(nodeMc);
        graph.addNode(nodeNc);
        graph.addNode(nodeOc);
        graph.addNode(nodePc);
        graph.addNode(nodeQc);
        graph.addNode(nodeRc);
        graph.addNode(nodeSc);
        graph.addNode(nodeTc);
        graph.addNode(nodeUc);
        graph.addNode(nodeVc);
        graph.addNode(nodeWc);
        graph.addNode(nodeXc);
        graph.addNode(nodeYc);
        graph.addNode(nodeZc);
        graph.addNode(nodeAAc);
        graph.addNode(nodeABc);
        graph.addNode(nodeACc);
        graph.addNode(nodeADc);
        graph.addNode(nodeAFc);
        graph.addNode(nodeAGc);
        graph.addNode(nodeAIc);
        graph.addNode(nodeAJc);
        graph.addNode(nodeAKc);
        graph.addNode(nodeALc);
        graph.addNode(nodeAMc);
        graph.addNode(nodeANc);
        graph.addNode(nodeAOc);
        graph.addNode(nodeAPc);
        graph.addNode(nodeAQc);
        graph.addNode(nodeARc);
        graph.addNode(nodeASc);
        graph.addNode(nodeATc);
        graph.addNode(nodeAUc);
        graph.addNode(nodeAVc);
        graph.addNode(nodeAWc);
        graph.addNode(nodeAXc);
        graph.addNode(nodeAYc);
        graph.addNode(nodeAZc);
        graph.addNode(nodeBAc);
        graph.addNode(nodeBBc);
        graph.addNode(nodeBCc);
        graph.addNode(nodeBDc);
        graph.addNode(nodeBEc);
        graph.addNode(nodeBFc);
        graph.addNode(nodeBGc);
        graph.addNode(nodeBHc);
        graph.addNode(nodeBIc);
        graph.addNode(nodeBJc);
        graph.addNode(nodeBKc);
        graph.addNode(nodeBLc);
        graph.addNode(nodeBMc);
        graph.addNode(nodeBNc);
        graph.addNode(nodeBOc);
        graph.addNode(nodeBPc);
        graph.addNode(nodeBQc);
        graph.addNode(nodeBRc);
        graph.addNode(nodeBSc);
        graph.addNode(nodeBTc);
        graph.addNode(nodeBUc);
        graph.addNode(nodeBVc);
        graph.addNode(nodeBWc);
        graph.addNode(nodeBXc);
        graph.addNode(nodeBYc);
        graph.addNode(nodeBZc);
        graph.addNode(nodeCAc);
        graph.addNode(nodeCBc);
        graph.addNode(nodeCCc);
        graph.addNode(nodeCDc);
        graph.addNode(nodeCEc);
        graph.addNode(nodeCFc);
        graph.addNode(nodeCGc);
        graph.addNode(nodeCHc);
        graph.addNode(nodeCIc);
        graph.addNode(nodeCJc);
        graph.addNode(nodeCKc);
        graph.addNode(nodeCLc);
        graph.addNode(nodeCMc);
        graph.addNode(nodeCNc);
        graph.addNode(nodeCOc);
        graph.addNode(nodeCPc);
        graph.addNode(nodeCQc);
        graph.addNode(nodeCRc);
        graph.addNode(nodeCSc);
        graph.addNode(nodeCTc);
        graph.addNode(nodeCUc);
        graph.addNode(nodeCVc);
        graph.addNode(nodeCXc);
        graph.addNode(nodeCYc);
        graph.addNode(nodeCZc);
        graph.addNode(nodeDAc);
        graph.addNode(nodeDBc);
        graph.addNode(nodeDCc);
        graph.addNode(nodeDDc);
        graph.addNode(nodeDFc);
        graph.addNode(nodeStop1c);
        graph.addNode(nodeStop2c);
        graph.addNode(nodeStop3c);
        graph.addNode(nodeStop4c);
        graph.addNode(nodeStop5c);
        graph.addNode(nodeStop6c);
        graph.addNode(nodeStop7c);
        graph.addNode(nodeStop8c);
        graph.addNode(nodeStop9c);
        graph.addNode(nodeStop10c);
        graph.addNode(nodeStop11c);
        graph.addNode(nodeStop12c);
        graph.addNode(nodeStop13c);
        graph.addNode(nodeBStop1c);
        graph.addNode(nodeBStop2c);
        graph.addNode(nodeBStop3c);
        graph.addNode(nodeBStop4c);
        graph.addNode(nodeBStop5c);
        graph.addNode(nodeBStop6c);
        graph.addNode(nodeBStop7c);


        return nodeList;
    }
}


