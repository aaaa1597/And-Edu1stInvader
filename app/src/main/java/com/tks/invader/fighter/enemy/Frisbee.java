package com.tks.invader.fighter.enemy;

import com.tks.invader.R;
import com.tks.invader.bullet.FrisbeeBullet;
import com.tks.invader.scene.GameSceneBase;
import com.tks.invader.scene.PlaySceneBase;

public class Frisbee extends EnemyFighterBase {

    public Frisbee(GameSceneBase scene) {
        super(scene);
        sprite = loadSprite(R.drawable.enemy_00); // 敵の画像を読み込む
    }

    /**
     * 弾を発射する
     */
    void fire() {
        FrisbeeBullet bullet = new FrisbeeBullet(scene, this);
        ((PlaySceneBase) scene).addBullet(bullet);
    }

    @Override
    public void update() {
        // スーパークラスの処理を行わせる
        super.update();
        // 指定したフレームで処理を行わせる
        if (frameCount == 30 * 5) {
            // 150フレーム経過したら弾を撃って行動カウンターをリセットする。
            fire();
            resetFrameCount();

        } else if (frameCount % 30 == 0) {
            // 30フレームに１回、15フレーム前進する
            offsetPosition(0, 15);
        }
    }
}