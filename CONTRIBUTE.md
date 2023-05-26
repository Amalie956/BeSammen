# Velkommen til vores contributing guide! 👋
Her kan du finde instruktionerne til hvordan du begynder at udvikle i vores app og hvordan du får adgang til vores app 'BeSammen'.
For at navigere hurtigt til specifikke afsnit i denne vejledning, kan du bruge indholdsfortegnelsesikonet <img src="https://github.com/Amalie956/BeSammen/assets/112120321/64a3da23-f729-4b96-a3bb-8ed541ac9461" width="19">, som findes i øverste venstre hjørne af dette dokument.


## Kom i gang
Nedenfor vil du finde afsnit, der omhandler vigtige oplysninger, som det er vigtigt for nye medlemmer at være bekendt med.

#### 📓Rammeværktøj
Vi benytter Github Project til at planlægge vores opgaver. Disse opgaver bliver kaldt [*issues*](https://docs.github.com/en/issues/tracking-your-work-with-issues/about-issues).

Vores [*project*](https://github.com/users/Amalie956/projects/5/views/1) ser således ud: 
<details><summary>Kanban (klik for at ekspandere)</summary>

![image](https://github.com/Amalie956/BeSammen/assets/111952804/2f38d729-a11d-4464-9e0c-4f19710eb1f1)

</details>


##### Issue
Vi bruger issues som opgaver der skal løses i projektet. Vi giver hver issue en kortfattet overskrift.
For langt de fleste issues, har vi assigned mindst en contributor som er ansvarlig for den tildelte opgave.
Vi tilføjer labels i forskellige farver og navngiver relevante emner til vores issues, som de tilhører. Det hjælper os med at få bedre overblik over hvilke opgaver har med hvilke emner at gøre med, som også ses på det ovenstående billede i drope down menuen &uarr;

#### <img src="https://github.com/Amalie956/BeSammen/assets/112120321/07280789-e60b-4567-a263-bf61d1180869" width="19"> Android Studio
Vi udvikler vores app i Android Studio. Du skal derfor [downloade](https://developer.android.com/studio) det. [Her](https://developer.android.com/studio/install) er der en guide til hvordan du installere det

Derefter skal du klone vores *repository* ned i dit projekt. Se hvordan du gør [her](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository).

##### Branch
Vi laver en ny branch for det issue, vi skal løse. Nedenunder ses guide i billeder:

![Slice 6(1)](https://github.com/Amalie956/BeSammen/assets/112120321/390d9855-86ae-4cc9-a337-d337c830eb53)

For at pushe din kode skal du først lave et commit og derefter foretage en push, som du får guide til i nedenstående afsnit &darr;.

##### Workflow
Når du udfører en push, gennemgår dit commit en automatiseret workflow. Dette [workflow](https://github.com/Amalie956/BeSammen/blob/main/.github/workflows/CI-mini.yml) har til formål at kontrollere committen for merge konflikter. Hvis der ikke opstår merge konflikter, bliver din kode pushet til main. Hvis der opstår merge konflikter skal du selv ind i pull request og løse dem. Der er en guide [her](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/addressing-merge-conflicts/resolving-a-merge-conflict-on-github)

Vi har iøvrigt også lavet nogle ui test, som ikke er blevet automatiseret endnu, som ses [her](https://github.com/Amalie956/BeSammen/tree/main/app/src/androidTest/java/com/example/besammen/ui). Dem kan du køre ved at trykke 'run'. 

#### 👩‍👩‍👧‍👦Contributors
I dette team er vi fire medlemmer indtil videre. Alle fra Københavns Erhvervsakademi. Så er du advaret!

Hvis du vil i kontakt med andre i vores team kan du lave et mention ved at bruge `@` plus brugernavnet. Dette vil udløse en notifikation, så kan vedkommende hjælpe dig. Nedenunder kan ses vores brugernavne:
- [Abdul](https://github.com/Abdu1RH) &rarr; `@Abdu1RH` , IT-Arkitektur studerende ([Se alle Abduls commits](https://github.com/Amalie956/BeSammen/commits?author=Abdu1RH))
- [Amalie](https://github.com/Amalie956) &rarr; `@Amalie956`, IT-Arkitektur studerende ([Se alle Amalies commits](https://github.com/Amalie956/BeSammen/commits?author=Amalie956))
- [Klara](https://github.com/Catlover2200) &rarr; `@Catlover2200`, IT-Arkitektur studerende ([Se alle Klaras commits](https://github.com/Amalie956/BeSammen/commits?author=Catlover2200))
- [Maheen](https://github.com/Mahe0055) &rarr; `@Mahe0055`, IT-Arkitektur studerende ([Se alle Maheens commits](https://github.com/Amalie956/BeSammen/commits?author=Mahe0055 ))
