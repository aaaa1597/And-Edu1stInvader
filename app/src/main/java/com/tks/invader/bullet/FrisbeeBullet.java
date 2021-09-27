package com.tks.invader.bullet;

import com.tks.invader.R;
import com.tks.invader.fighter.FighterBase;
import com.tks.invader.scene.GameSceneBase;
import com.tks.invader.scene.PlaySceneBase;

public class FrisbeeBullet extends BulletBase {

    public FrisbeeBullet(GameSceneBase scene, FighterBase shooter) {
        super(scene, shooter);

        sprite = loadSprite(R.drawable.bullet_enemy); // 弾の画像を保持する
        setPosition(shooter.getPositionX(), shooter.getPositionY()); // 位置を発射した戦闘機に合わせる

        // サウンドを鳴らす
        scene.playSE(R.raw.enemy_bullet);
    }

    @Override
    public void update() {
        offsetPosition(0, 10); // 下へ向かって移動させる

        FighterBase player = ((PlaySceneBase) scene).getPlayer();
        // プレイヤーと弾が衝突していたらダメージ処理を行う
        if (player.isIntersect(this)) {
            enable = false;
            player.onDamage(this);
        }

    }
}