package Game;

import java.util.*;
import java.util.Map.Entry;

public class Map {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA){
        nodes.add(nodeA);
    }

    public static Map calculateShortestPathFromSource(Map graph, Node source){
        source.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes= new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() !=0){
            Node currentNode=getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for(Entry <Node, Integer> adjacencyPair: currentNode.getAdjacentNodes().entrySet()){
                Node adjacentNode=adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
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

    public static List<Node> routeBetweenNodes(Map graph, Node startPoint, Node endPoint){
        graph=Map.calculateShortestPathFromSource(graph, startPoint);
        return (List<Node>) endPoint.getShortestPath();
    }

    public static List<Node> createLevel1(Map graph){

        List<Node> nodeList=new ArrayList<>();

        Node nodeA = new Node("A",16,516);
        Node nodeB = new Node("B",16,607);
        Node nodeC = new Node("C",15,777);
        Node nodeD = new Node("D",78,777);
        Node nodeE = new Node("E",78,607);
        Node nodeF = new Node("F",219,777);
        Node nodeG = new Node("G",219,640);
        Node nodeH = new Node("H",144,608);
        Node nodeI = new Node("I",144,640);
        Node nodeJ = new Node("J",144,513);
        Node nodeK = new Node("K",247,556);
        Node nodeL = new Node("L",298,556);
        Node nodeM = new Node("M",300,640);
        Node nodeN = new Node("N",321,777);
        Node nodeO = new Node("O",321,720);
        Node nodeP = new Node("P",463,777);
        Node nodeQ = new Node("Q",463,725);
        Node nodeR = new Node("R",440,640);
        Node nodeS = new Node("S",579,777);
        Node nodeT = new Node("T",622,777);
        Node nodeU = new Node("U",622,723);
        Node nodeV = new Node("V",579,723);
        Node nodeW = new Node("W",529,707);
        Node nodeX = new Node("X",440,695);
        Node nodeY = new Node("Y",529,640);
        Node nodeZ = new Node("Z",622,640);
        Node nodeAA = new Node("AA",390,570);
        Node nodeAB = new Node("AB",390,640);
        Node nodeAC = new Node("AC",390,512);
        Node nodeAD = new Node("AD",247,512);
        Node nodeAE = new Node("AE",247,413);
        Node nodeAF = new Node("AF",144,268);
        Node nodeAG = new Node("AG",75,268);
        Node nodeAH = new Node("AH",22,268);
        Node nodeAI = new Node("AI",22,198);
        Node nodeAJ = new Node("AJ",75,198);
        Node nodeAK = new Node("AK",224,268);
        Node nodeAL = new Node("AL",410,268);
        Node nodeAM = new Node("AM",550,268);
        Node nodeAN = new Node("AN",621,268);
        Node nodeAO = new Node("AO",621,358);
        Node nodeAP = new Node("AP",621,433);
        Node nodeAQ = new Node("AQ",621,570);
        Node nodeAR = new Node("AR",743,702);
        Node nodeAS = new Node("AS",785,735);
        Node nodeAT = new Node("AT",807,752);
        Node nodeAU = new Node("AU",843,718);
        Node nodeAV = new Node("AV",752,769);
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
        Node nodeBK = new Node("BK",1132,749);
        Node nodeBL = new Node("BL",1084,749);
        Node nodeBM = new Node("BM",1153,780);
        Node nodeBN = new Node("BN",1126,796);
        Node nodeBO = new Node("BO",1164,796);
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




        nodeA.addDestination(nodeB);

        nodeB.addDestination(nodeA);
        nodeB.addDestination(nodeC);
        nodeB.addDestination(nodeE);

        nodeC.addDestination(nodeB);
        nodeC.addDestination(nodeD);

        nodeD.addDestination(nodeC);
        nodeD.addDestination(nodeE);
        nodeD.addDestination(nodeF);

        nodeE.addDestination(nodeB);
        nodeE.addDestination(nodeD);
        nodeE.addDestination(nodeH);
        nodeE.addDestination(nodeAG);

        nodeF.addDestination(nodeD);
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
        nodeP.addDestination(nodeS);

        nodeQ.addDestination(nodeP);
        nodeQ.addDestination(nodeW);
        nodeQ.addDestination(nodeX);

        nodeR.addDestination(nodeX);
        nodeR.addDestination(nodeY);
        nodeR.addDestination(nodeAB);

        nodeS.addDestination(nodeP);
        nodeS.addDestination(nodeT);
        nodeS.addDestination(nodeV);

        nodeT.addDestination(nodeS);
        nodeT.addDestination(nodeU);
        nodeT.addDestination(nodeAR);

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
        nodeZ.addDestination(nodeDF);

        nodeAA.addDestination(nodeL);
        nodeAA.addDestination(nodeAB);
        nodeAA.addDestination(nodeAC);
        nodeAA.addDestination(nodeAQ);

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
        nodeAE.addDestination(nodeAN);

        nodeAF.addDestination(nodeJ);
        nodeAF.addDestination(nodeAE);
        nodeAF.addDestination(nodeAG);
        nodeAF.addDestination(nodeAK);
        nodeAF.addDestination(nodeDD);

        nodeAG.addDestination(nodeE);
        nodeAG.addDestination(nodeAF);
        nodeAG.addDestination(nodeAH);
        nodeAG.addDestination(nodeAJ);

        nodeAH.addDestination(nodeAG);
        nodeAH.addDestination(nodeAI);

        nodeAI.addDestination(nodeAH);
        nodeAI.addDestination(nodeAJ);

        nodeAJ.addDestination(nodeAH);
        nodeAJ.addDestination(nodeAJ);

        nodeAK.addDestination(nodeAF);
        nodeAK.addDestination(nodeAL);
        nodeAK.addDestination(nodeCM);

        nodeAL.addDestination(nodeAK);
        nodeAL.addDestination(nodeAM);
        nodeAL.addDestination(nodeCL);

        nodeAM.addDestination(nodeAL);
        nodeAM.addDestination(nodeAN);
        nodeAM.addDestination(nodeCK);

        nodeAN.addDestination(nodeAE);
        nodeAN.addDestination(nodeAM);
        nodeAN.addDestination(nodeAO);
        nodeAN.addDestination(nodeBY);

        nodeAO.addDestination(nodeAN);
        nodeAO.addDestination(nodeAP);
        nodeAO.addDestination(nodeBE);

        nodeAP.addDestination(nodeAO);
        nodeAP.addDestination(nodeAQ);
        nodeAP.addDestination(nodeBD);

        nodeAQ.addDestination(nodeZ);
        nodeAQ.addDestination(nodeAA);
        nodeAQ.addDestination(nodeAP);

        nodeAQ.addDestination(nodeZ);
        nodeAQ.addDestination(nodeAA);
        nodeAQ.addDestination(nodeAP);

        nodeAR.addDestination(nodeT);
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
        nodeAW.addDestination(nodeBJ);
        nodeAW.addDestination(nodeDF);

        nodeAX.addDestination(nodeAW);
        nodeAX.addDestination(nodeAY);
        nodeAX.addDestination(nodeBG);

        nodeAY.addDestination(nodeAX);
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
        nodeBG.addDestination(nodeBG);
        nodeBG.addDestination(nodeBH);

        nodeBH.addDestination(nodeBG);
        nodeBH.addDestination(nodeBI);
        nodeBH.addDestination(nodeBP);

        nodeBI.addDestination(nodeBH);
        nodeBI.addDestination(nodeBJ);

        nodeBJ.addDestination(nodeAW);
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
        nodeBP.addDestination(nodeBR);

        nodeBQ.addDestination(nodeBF);
        nodeBQ.addDestination(nodeBR);
        nodeBQ.addDestination(nodeBS);

        nodeBR.addDestination(nodeBP);
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
        nodeCC.addDestination(nodeCF);

        nodeCD.addDestination(nodeCC);

        nodeCE.addDestination(nodeCC);

        nodeCF.addDestination(nodeCA);
        nodeCF.addDestination(nodeCC);
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
        nodeCI.addDestination(nodeCJ);
        nodeCI.addDestination(nodeCL);
        nodeCI.addDestination(nodeCN);

        nodeCJ.addDestination(nodeBZ);
        nodeCJ.addDestination(nodeCI);
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
        nodeCQ.addDestination(nodeCT);

        nodeCR.addDestination(nodeCN);
        nodeCR.addDestination(nodeCP);
        nodeCR.addDestination(nodeCS);

        nodeCS.addDestination(nodeCG);
        nodeCS.addDestination(nodeCR);
        nodeCS.addDestination(nodeCT);

        nodeCT.addDestination(nodeCH);
        nodeCT.addDestination(nodeCQ);
        nodeCT.addDestination(nodeCS);
        nodeCT.addDestination(nodeCU);

        nodeCU.addDestination(nodeCT);
        nodeCU.addDestination(nodeCV);

        nodeCV.addDestination(nodeCH);
        nodeCV.addDestination(nodeCU);

        nodeCX.addDestination(nodeCH);
        nodeCX.addDestination(nodeCY);
        nodeCX.addDestination(nodeCZ);

        nodeCY.addDestination(nodeCX);

        nodeCZ.addDestination(nodeCX);
        nodeCZ.addDestination(nodeDA);
        nodeCZ.addDestination(nodeDB);

        nodeDA.addDestination(nodeCZ);

        nodeDB.addDestination(nodeCZ);
        nodeDB.addDestination(nodeDC);

        nodeDC.addDestination(nodeDB);

        nodeDD.addDestination(nodeAF);
        nodeDD.addDestination(nodeAJ);
        nodeDD.addDestination(nodeCM);
        nodeDD.addDestination(nodeCO);

        nodeDF.addDestination(nodeZ);
        nodeDF.addDestination(nodeAR);
        nodeDF.addDestination(nodeAW);

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

        return nodeList;

    }
}
