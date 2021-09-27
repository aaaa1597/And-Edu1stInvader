package com.tks.invader.fighter;

import android.graphics.Rect;

import com.tks.invader.GameSprite;
import com.tks.invader.bullet.BulletBase;
import com.tks.invader.scene.GameSceneBase;

public abstract class FighterBase extends GameSprite {

    /**
     * 戦闘機のヒットポイント。
     * デフォルトは1にしておく。
     */
    protected int hp = 1;

    public FighterBase(GameSceneBase scene) {
        super(scene);

    }

    /**
     * ２つのスプライトが衝突している場合、trueを返す。
     * @param other
     * @return
     */
    public boolean isIntersect(GameSprite other) {

        if (isDead()) {
            // 撃墜済みの戦闘機に当たり判定は発生しない。
            return false;
        }
        Rect mySpriteArea = getSprite().getDstRect();
        Rect otherSpriteArea = other.getSprite().getDstRect();
        return Rect.intersects(mySpriteArea, otherSpriteArea);
    }

    /**
    * 弾が当たったらこのメソッドに通知される。
    * @param bullet
    */
    public void onDamage(BulletBase bullet) {
        --hp;
    }

    /**
    * この機体が撃墜されていたらtrueを返す。
    * @return
    */
    public boolean isDead() {
        return hp <= 0;
    }
}