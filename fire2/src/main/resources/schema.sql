-- =========================================
-- シグナル履歴テーブル
-- テクニカル分析の結果を保存する
-- =========================================
CREATE TABLE IF NOT EXISTS trading_signals (

    id BIGINT AUTO_INCREMENT PRIMARY KEY, 
    -- 主キー（自動採番）

    symbol VARCHAR(20) NOT NULL,          
    -- 銘柄（例: BTCUSDT）

    signal_type VARCHAR(10) NOT NULL,     
    -- シグナル種別（BUY / NONE など）

    price DECIMAL(18,8),                  
    -- 現在価格

    sma_short DECIMAL(18,8),              
    -- 短期移動平均（5SMA）

    sma_long DECIMAL(18,8),               
    -- 長期移動平均（25SMA）

    rsi DECIMAL(10,4),                    
    -- RSI（14期間）

    current_volume DECIMAL(18,8),         
    -- 現在の出来高

    avg_volume DECIMAL(18,8),             
    -- 過去20本の平均出来高

    condition1 BOOLEAN,                   
    -- 条件①：短期MA > 長期MA

    condition2 BOOLEAN,                   
    -- 条件②：RSIが50以上70未満

    condition3 BOOLEAN,                   
    -- 条件③：出来高が平均より大きい

    message TEXT,                         
    -- LINE通知用メッセージ

    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
    -- 作成日時（自動で現在時刻）
);

-- =========================================
-- 銘柄マスタテーブル
-- BOTが監視する対象銘柄を管理
-- =========================================
CREATE TABLE IF NOT EXISTS symbols (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    -- 主キー

    symbol VARCHAR(20) NOT NULL UNIQUE,
    -- 銘柄コード（重複禁止）

    is_active BOOLEAN DEFAULT TRUE,
    -- 監視フラグ（TRUE=監視対象、FALSE=停止）

    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
    -- 登録日時
);

-- =========================================
-- 監視対象銘柄テーブル
-- BOTが監視する銘柄を管理する
-- =========================================
CREATE TABLE IF NOT EXISTS symbols (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    -- 主キー

    symbol VARCHAR(20) NOT NULL UNIQUE,
    -- 銘柄コード（例: BTCUSDT）
    -- 重複登録を防ぐため UNIQUE 制約を付与

    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    -- 監視対象かどうか
    -- TRUE: 監視する / FALSE: 監視しない

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    -- 作成日時
);



-- =========================================
-- シグナル履歴テーブル
-- テクニカル分析結果を保存する
-- 後で勝率検証や通知履歴分析に使える
-- =========================================
CREATE TABLE IF NOT EXISTS trading_signals (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    -- 主キー

    symbol VARCHAR(20) NOT NULL,
    -- 銘柄コード（例: BTCUSDT）

    signal_type VARCHAR(10) NOT NULL,
    -- シグナル種別
    -- 例: BUY / NONE

    price DECIMAL(18,8),
    -- シグナル判定時の現在価格

    sma_short DECIMAL(18,8),
    -- 短期移動平均
    -- 現在は 5SMA を想定

    sma_long DECIMAL(18,8),
    -- 長期移動平均
    -- 現在は 25SMA を想定

    rsi DECIMAL(10,4),
    -- RSI値
    -- 現在は 14期間を想定

    current_volume DECIMAL(18,8),
    -- 最新足の出来高

    avg_volume DECIMAL(18,8),
    -- 平均出来高
    -- 現在は直近20本平均を想定

    condition1 BOOLEAN,
    -- 条件① 短期MA > 長期MA を満たしたか

    condition2 BOOLEAN,
    -- 条件② RSIが50以上70未満を満たしたか

    condition3 BOOLEAN,
    -- 条件③ 現在出来高 > 平均出来高 を満たしたか

    message TEXT,
    -- 通知用メッセージ本文

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    -- シグナル作成日時
);


-- =========================================
-- 通知ログテーブル
-- LINE通知を送った履歴を保存する
-- 同一銘柄への連続通知制御にも使える
-- =========================================
CREATE TABLE IF NOT EXISTS notification_logs (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    -- 主キー

    symbol VARCHAR(20) NOT NULL,
    -- 通知対象銘柄

    message TEXT,
    -- 実際に送信したメッセージ

    sent_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    -- 通知送信日時

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    -- レコード作成日時
);