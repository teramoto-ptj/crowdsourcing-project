DATA 案件作成コマンド =
    未検証タイトル
    AND 未検証詳細
    AND 未検証求めるスキル
    AND 未検証予算
    AND 未検証募集人数
    AND 未検証依頼形式
    AND 未検証応募期限

DATA 依頼形式 =
    コンペ or プロジェクト

DATA 新規案件 =
    タイトル
    AND 詳細
    AND 求めるスキル
    AND 予算
    AND 募集人数
    AND 依頼形式
    AND 応募期限

DATA タイトル =
    String 文字数 3~100 前後に空白が入っていない

DATA 詳細 =
    String 文字数 3~2000 前後に空白が入っていない

DATA 求めるスキル =
    String 文字数 3~2000 前後に空白が入っていない

DATA 予算 =
    金額 0~100000000

DATA 金額 =
    数量
    AND 通貨

DATA 募集人数 =
    Int 1~100

DATA 応募期限 =
    DATE 本日日付+1 日 0:00/~2050/12/31 0:00

DATA 案件 =
    新規案件
    AND 案件 ID

DATA 案件 ID =
    NanoID で作成（アプリケーション側で発番するため DB で発番する必要なし）
