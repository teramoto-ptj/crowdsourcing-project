DATA 案件作成コマンド =
    未検証タイトル
    AND 未検証詳細
    AND 未検証求めるスキル
    AND 未検証予算
    AND 未検証募集人数
    AND 未検証依頼形式
    AND 未検証応募期限

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

DATA 依頼形式 =
    コンペ or プロジェクト

DATA 応募期限 =
    DATE 本日日付+1 日 0:00/~2050/12/31 0:00

DATA 案件 =
    新規案件
    AND 案件ID

DATA 案件ID =
    NanoID で作成（アプリケーション側で発番するため DB で発番する必要なし）


DATA 案件検索結果 =
    リスト of 案件


DATA 応募作成コマンド =
    未検証コンペ応募 or 未検証プロジェクト応募

DATA 未検証コンペ応募 =
    未検証ファイル
    AND 未検証メッセージ

DATA 未検証プロジェクト応募 =
    未検証見積金額
    AND 未検証完了予定日
    AND 未検証メッセージ

DATA 新規応募 =
    新規コンペ応募 or 新規プロジェクト応募

DATA 新規コンペ応募 =
    ファイル
    AND (メッセージ)

DATA 新規プロジェクト応募 =
    見積金額
    AND 完了予定日
    AND (メッセージ)

DATA ファイル =
    ファイル形式 ?(.pptx .xlsx .pdf) 容量 0~2MB

DATA 見積金額 =
    金額 0~100000000

DATA 完了予定日 =
    DATE 本日日付+1 日 0:00/~2050/12/31 0:00

DATA メッセージ =
    String 文字数 1~2000 前後に空白が入っていない

DATA 応募 =
    新規応募
    AND 案件ID
    AND 応募ID

DATA 応募ID =
    NanoID で作成（アプリケーション側で発番するため DB で発番する必要なし）


DATA 応募通知 =
    応募
    AND 応募通知メッセージ

DATA 応募通知メッセージ =
    String 応募テンプレート

DATA 応募検索結果 =
    リスト of 応募

DATA 合否判定コマンド =
    AND 案件ID
    AND 応募ID
    AND 未検証合否内容

DATA 合否判定 =
    AND 案件ID
    AND 応募ID
    AND 合否内容

DATA 合否内容 =
    合格 or 不合格


DATA 合格通知 =
    案件
    応募
    AND 合格通知メッセージ

DATA 合格通知メッセージ =
    String 一次選考通過テンプレート


DATA 不合格通知 =
    案件
    応募
    AND 不合格通知メッセージ

DATA 不合格通知メッセージ =
    String お祈りテンプレート