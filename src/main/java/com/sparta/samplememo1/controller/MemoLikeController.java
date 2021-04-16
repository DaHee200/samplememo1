//package com.sparta.samplememo1.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller

import com.sparta.samplememo1.service.Const;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin(origins = Const.ClientServerHost)
//public class MemoLikeController {
//
//    private Object service;
//
//    @RequestMapping("/Memo")
//    public String communityDetail(@RequestParam int idx, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//        logger.info("request: /Memo");
//        Map<String, Object> resultMap = null;
//        Map<String, Object> idxMap = new HashMap<>();
//        int bbsidx = idx;
//        int useridx = 0;
//
//        try {
//            Map<String,Object> userInfo = (Map<String, Object>) session.getAttribute("userInfo");
//            // 사용자의 일련번호
//            useridx = Integer.parseInt(userInfo.get("idx").toString());
//
//            /* 생략 */
//            resultMap = service.Memo(bbsidx); // 게시판 상세정보 가져옴
//            idxMap.put("bbsidx", bbsidx); //게시글의 일련번호
//            idxMap.put("useridx", useridx);
//
//            Map<String,Object> likecheckMap = service.likecheck(idxMap);
//            //like 테이블 에서 사용자가 해당 게시글에 대해서 좋아요를 눌렀는지 확인
//            if(likecheckMap == null) {
////사용자가 좋아요를 한번도 누른적이 없으면
////like테이블에 데이터가 없으므로 null반환
//                model.addAttribute("likecheck",0);
//            }
//            else {
//                model.addAttribute("likecheck",likecheckMap.get("likecheck"));
//            }
//
//            model.addAttribute("likecnt",resultMap.get("likecnt"));
//            model.addAttribute("bbsidx",bbsidx);
//            model.addAttribute("useridx",useridx);
//            /* 생략 */
//        } catch (Exception e) {
//            logger.debug(e.getMessage());
//        }
//        return "Memo";
//    }
//
//    /* Controller */
//    //좋아요 눌렀을때
//    @RequestMapping("/clickLike")
//    @ResponseBody
//    public Map<String,Object> clickLike(@RequestParam Map<String,Object> commandMap){
//        logger.info("request: /clickLike");
//        int resultCode = 1;
//        int likecheck = 1;
//        Map<String,Object> map = new HashMap<>();
//        Map<String,Object> likecntMap = new HashMap<>();
//        Map<String,Object> resultMap = new HashMap<>();
//        try {
//            map = service.likecheck(commandMap);
//            if(map == null) {
//                //처음 좋아요 누른것 likecheck=1, 좋아요 빨간색이 되야됨
//                service.insertLikeBtn(commandMap); //좋아요 테이블 인서트
//                service.updateLikeCntPlus(commandMap); //bbs 테이블 업데이트 +1
//                resultCode = 1;
//            }
//            else if(Integer.parseInt(map.get("likecheck").toString()) == 0) {
//                //좋아요 처음은 아니고 취소했다가 다시 눌렀을때 likecheck=1, 좋아요 빨간색 되야됨
//                commandMap.put("likecheck",likecheck);
//                service.updateLikeCheck(commandMap); //좋아요 테이블 업데이트
//                service.updateLikeCntPlus(commandMap); // bbs테이블 +1
//                resultCode = 1;
//            }
//            else {
//                //좋아요 취소한거 likecheck=0, 빈하트 되야됨
//                likecheck = 0;
//                commandMap.put("likecheck", likecheck);
//                service.updateLikeCheck(commandMap);
//                service.updateLikeCntMinus(commandMap);
//                resultCode = 0;
//            }
//            resultMap = service.getLikeCnt(commandMap);
//            // 해당 게시글 테이블의 likecnt칼럼  update가 끝난후 likecnt값 가져옴
//            resultMap.put("likecheck", likecheck);
//        } catch (Exception e) {
//            logger.debug(e.getMessage());
//            resultCode = -1;
//        }
//
//        resultMap.put("resultCode", resultCode);
//        //resultCode가 1이면 빨간하트 0이면 빈하트
//        return resultMap;
//    }
//
//}
