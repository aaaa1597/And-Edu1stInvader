package com.tks.invader.fighter;

import com.tks.invader.Define;
import com.tks.invader.R;
import com.tks.invader.bullet.PlayerBullet;
import com.tks.invader.input.AttackButton;
import com.tks.invader.input.JoyStick;
import com.tks.invader.scene.GameSceneBase;
import com.tks.invader.scene.PlaySceneBase;
import com.eaglesakura.lib.android.game.math.Vector2;

public class PlayerFighter extends FighterBase {

    /**
     * 操作用のジョイスティック
     */
    JoyStick joyStick;

    /**
     * 攻撃ボタン
     */
    AttackButton shotButton;

    public PlayerFighter(GameSceneBase scene, JoyStick joyStick, AttackButton shotButton) {
        super(scene);
        this.joyStick = joyStick;
        this.shotButton = shotButton; // 攻撃ボタンを保持する
        // プレイヤー画像の読み込み
        sprite = loadSprite(R.drawable.player);

        // 初期位置を画面の下側中央にする
        setPosition(Define.VIRTUAL_DISPLAY_WIDTH / 2, Define.VIRTUAL_DISPLAY_HEIGHT - 100);
    }

    /**     
     * プレイヤー位置を更新する
     */
    void updatePosition() {
        // 移動させたい向きのベクトルを取得する
        Vector2 move = joyStick.getMoveVector();

        // 1フレームで最大5ピクセル移動するようにする
        move.mul(5.0f);

        // その方向へ移動させる
        offsetPosition(move.x, move.y);

        //! 位置をプレイエリア内に補正する
        correctPosition();
    }

    /**
     * 弾を発射し、ステージへ追加する。
     */
    void fire() {
        PlayerBullet bullet = new PlayerBullet(scene, this);
        ((PlaySceneBase) scene).addBullet(bullet);
    }

    @Override
    public void update() {
        updatePosition();
        if (shotButton.isAttack()) {
            fire();
        }
    }
}