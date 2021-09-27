package com.tks.invader.bullet;

import com.tks.invader.GameSprite;
import com.tks.invader.fighter.FighterBase;
import com.tks.invader.scene.GameSceneBase;

public abstract class BulletBase extends GameSprite {

    /**
        * この弾を撃った機体を保持しておく
        */
    FighterBase shooter = null;

    /**
     * 弾が有効な場合、true
     */
    protected boolean enable = true;

    public BulletBase(GameSceneBase scene, FighterBase shooter) {
        super(scene);
        this.shooter = shooter;
    }

    /**
     * 弾が有効ならtrue
     * @return
     */
    public boolean isEnable() {
        return enable;
    }

    @Override
    public void draw() {
        // 弾が有効でないなら描画しない
        if (!isEnable()) {
            return;
        }
        super.draw();
    }
}