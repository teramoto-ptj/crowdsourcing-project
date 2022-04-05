# Mavenプロジェクトセットアップガイド

研修やワークショップで、GitからCloneしてIntelliJ IDEAにプロジェクトとして認識させ、Mavenが動いて依存ライブラリがインストールされ、テストが動かせるようになる。 ここまでで時間を喰ってしまうともったいないので、その事前準備をしておくためのリポジトリです。


## IntelliJ IDEAのインストール


[JetBrainsのページ](https://www.jetbrains.com/ja-jp/idea/download/) からダウンロードして、インストールします。
Ultimateとコミュニティの2つのエディションがありますが、コミュニティエディションを選択してください。
(お気に召したら、後ほど有償のUltimateエディションに切り替えるといいでしょう)


## プロジェクトのclone

IntelliJ IDEAを起動し、GitHubからこのリポジトリをcloneします。

![](https://i.gyazo.com/ce337feb7f314984e952954f0dc89104.png)

このリポジトリのURLを入力します。

[![Image from Gyazo](https://i.gyazo.com/94b136beeaeb9c7882c064ade39e6dba.png)](https://gyazo.com/94b136beeaeb9c7882c064ade39e6dba)

## JDKのセットアップ

もし、JDKがインストールされていなければ、以下のページにしたがい、IntelliJ IDEA上からインストールします。
https://www.jetbrains.com/help/idea/sdk.html

「Download JDK」を選択すると、複数のディストリビューションとバージョンが表示されますが、Oracle OpenJDKまたはAdoptOpenJDKの最新バージョンをダウンロードしておいてください。

## Mavenプロジェクトとして認識させる

プロジェクトを開くと、右端にMavenタブが表示されるので、これをクリックしタブを開きます。

[![Image from Gyazo](https://i.gyazo.com/115950cd06d2243486ff747b63380e9e.png)](https://gyazo.com/115950cd06d2243486ff747b63380e9e)

プロジェクトを開いた時点で、依存ライブラリのダウンロードが始まるはずですが、もし何も起こらないようであれば、このアイコンをクリックし明示的に再読み込みさせます。
この操作は、Mavenの構成ファイルであるpom.xmlを編集したときにも使うので覚えておいてください。

[![Image from Gyazo](https://i.gyazo.com/1ba7c668e8b66f61d4988fc40463a2bf.png)](https://gyazo.com/1ba7c668e8b66f61d4988fc40463a2bf)

## テストを実行する

左ペインでcontext/src/test/javaの下のHogeUseCaseImplTestをダブルクリックし、ファイルを開きます。
[![Image from Gyazo](https://i.gyazo.com/eb6388a2348fcaedbf3e50ec94599fcd.png)](https://gyazo.com/eb6388a2348fcaedbf3e50ec94599fcd)

SetupTestのコードが中央ペインに表示されるので、クラス定義左横の緑のアイコンをクリックし、Run Testを選択します。
これにより、HogeUseCaseImplTestがJUnitとして実行されます。

[![Image from Gyazo](https://i.gyazo.com/812c0e6c8e100c6f5f2c362edc80d78c.png)](https://gyazo.com/812c0e6c8e100c6f5f2c362edc80d78c)

テスト実行が完了し、Tests passedが緑色で表示されれば成功です。