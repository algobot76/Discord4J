/*
 * This file is part of Discord4J.
 *
 * Discord4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Discord4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Discord4J.  If not, see <http://www.gnu.org/licenses/>.
 */
package discord4j.core.spec;

import discord4j.common.json.request.GuildModifyRequest;
import discord4j.core.object.Region;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.VoiceChannel;
import discord4j.core.object.util.Snowflake;

import javax.annotation.Nullable;

public class GuildEditSpec implements Spec<GuildModifyRequest> {

    private final GuildModifyRequest.Builder requestBuilder = GuildModifyRequest.builder();

    public GuildEditSpec setName(String name) {
        requestBuilder.name(name);
        return this;
    }

    public GuildEditSpec setRegion(Region region) {
        requestBuilder.region(region.getId());
        return this;
    }

    public GuildEditSpec setVerificationLevel(Guild.VerificationLevel verificationLevel) {
        requestBuilder.verificationLevel(verificationLevel.getValue());
        return this;
    }

    public GuildEditSpec setDefaultMessageNotificationsLevel(Guild.NotificationLevel notificationsLevel) {
        requestBuilder.defaultMessageNoficiations(notificationsLevel.getValue());
        return this;
    }

    public GuildEditSpec setAfkChannelId(@Nullable Snowflake afkChannelId) {
        requestBuilder.afkChannelId(afkChannelId == null ? null : afkChannelId.asLong());
        return this;
    }

    public GuildEditSpec setAfkChannel(@Nullable VoiceChannel afkChannel) {
        return setAfkChannelId(afkChannel == null ? null : afkChannel.getId());
    }

    public GuildEditSpec setAfkTimeout(int afkTimeout) {
        requestBuilder.afkTimeout(afkTimeout);
        return this;
    }

    public GuildEditSpec setIcon(@Nullable String icon) { // TODO Icon class
        requestBuilder.icon(icon);
        return this;
    }

    public GuildEditSpec setOwnerId(Snowflake ownerId) {
        requestBuilder.ownerId(ownerId.asLong());
        return this;
    }

    public GuildEditSpec setOwner(Member member) {
        return setOwnerId(member.getId());
    }

    public GuildEditSpec setSplash(@Nullable String splash) {
        requestBuilder.splash(splash);
        return this;
    }

    @Override
    public GuildModifyRequest asRequest() {
        return requestBuilder.build();
    }
}
