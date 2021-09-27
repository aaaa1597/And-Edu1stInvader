package com.tks.invader.scene;

import com.tks.invader.Define;
import com.tks.invader.Font;
import com.tks.invader.InvaderGame;
import com.eaglesakura.lib.android.game.input.MultiTouchInput;
import com.eaglesakura.lib.android.game.scene.SceneBase;
import com.eaglesakura.lib.android.game.scene.SceneManager;

public class TitleScene extends GameSceneBase {
    /**
     * 文字表示用のフォント
     */
    Font font = null;

    public TitleScene(InvaderGame game) {
        super(game);
    }

    @Override
    public void onSceneStart(SceneManager manager, SceneBase before) {
        // フォントを生成する
        font = new Font(game);
    }

    @Override
    public void onSceneExit(SceneManager manager, SceneBase next) {
    }

    @Override
    public void onFrameBegin(SceneManager manager) {
    }

    @Override
    public void onFrameDraw(SceneManager manager) {
        // 背景を宇宙色に染める
        getSpriteManager().clear(0, 0, 64, 255);

        // "INVADER"の文字を中央に描画する
        {
            float fontScale = 2.0f;
            font.drawCenter("INVADER", Define.VIRTUAL_DISPLAY_WIDTH / 2, Define.VIRTUAL_DISPLAY_HEIGHT / 2, fontScale);
        }

        // 自分の名前を画面中央下側に描画する
        {
            float fontScale = 0.5f;
            String name = "@eaglesakura";
            font.drawCenter(name, Define.VIRTUAL_DISPLAY_WIDTH / 2, Define.VIRTUAL_DISPLAY_HEIGHT - 50, fontScale);
        }
    }

    @Override
    public void onFrameEnd(SceneManager manager) {

        MultiTouchInput input = game.getMultiTouchInput();
        if (input.isTouchOnce()) {
            // 画面のどこかをタップしたら次の画面へ遷移
            PlaySceneBase nextScene = new PlaySceneStage1(game);
            manager.setNextScene(nextScene);
        }
    }

    @Override
    public void onGamePause(SceneManager manager) {
    }

    @Override
    public void onGameResume(SceneManager manager) {
    }

}