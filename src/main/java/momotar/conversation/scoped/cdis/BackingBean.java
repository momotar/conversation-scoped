package momotar.conversation.scoped.cdis;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author Natsuki
 */
@Named(value = "backingBean")
@ConversationScoped
public class BackingBean implements Serializable {
    private String word;
    private String meaning;
    
    private String example;
    private String translation;
    private ArrayList<BackingBean> words;
    
    @Inject
    Conversation conv;
    
    public String toView01() {
            if (conv.isTransient()) {
                conv.begin();
                System.out.println("会話スコープ開始：画面01（単語入力）へ");
            }
        return "view01.xhtml";
    }
    
    public String toView02() {
            System.out.println("画面02（例文入力）へ");
        return "view02.xhtml";
    }
    
    public String toView03() {
            System.out.println("画面03（入力確認）へ");
        return "view03.xhtml";
    }
    
    public String toConvFinish() {
        conv.end();
        System.out.println("開始画面00 会話スコープ終了");
        return "index.xhtml";
    }

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getExample() {
        return example;
    }
    public void setExample(String example) {
        this.example = example;
    }

    public String getTranslation() {
        return translation;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }   
}
