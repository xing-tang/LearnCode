#ifndef LEARNCODE_JZ24_翻转链表_H
#define LEARNCODE_JZ24_翻转链表_H

class JZ24_翻转链表 {
public:
    ListNode* ReverseList(ListNode* pHead) {
        ListNode* pre = nullptr;
        ListNode* curr = pHead;
        ListNode* next = nullptr;
        while(curr){
            next = curr->next;
            curr->next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
};



#endif //LEARNCODE_JZ24_翻转链表_H
